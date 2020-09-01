package com.chad.portfolio.pokerocket.camel.routebuilders;

//import com.chad.portfolio.pokerocket.model.Pokemon;

import com.chad.portfolio.pokerocket.PokeApiSync;
import com.chad.portfolio.pokerocket.camel.SystemProperties;
import com.chad.portfolio.pokerocket.camel.exceptions.SystemLevelException;
import com.chad.portfolio.pokerocket.camel.factories.EndpointFactory;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxy;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxyFactory;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxy;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxyFactory;
import com.chad.portfolio.pokerocket.impl.StatefullNextPokemonResolver;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokeApiSyncRoutes implements RoutesBuilder {

    private static Logger log = LoggerFactory.getLogger(PokeApiSyncRoutes.class);

    protected static final Integer MIN_POLL_PERIOD = 5000;

    private PokeApiSync pokeSync;
    private PokeApiProxy pokeApiProxy;
    private PokeRocketEndpointsProxy pokeRocketEndpointsProxy;

    private String timerEndpoint;


    public PokeApiSyncRoutes(String pokeApiUrl, String pokeRocketEndpointUrl, PollProperties pollProperties) throws SystemLevelException {

        validatePollParameters(pollProperties);

        this.timerEndpoint = EndpointFactory.SimpleTimer(
            pollProperties.getPollPeriod(),
            pollProperties.getPollDelay(),
            pollProperties.getPollRepeatCount()
        );

        this.pokeApiProxy = PokeApiProxyFactory.Create(pokeApiUrl);
        this.pokeRocketEndpointsProxy = PokeRocketEndpointsProxyFactory.Create(pokeRocketEndpointUrl);

        this.pokeSync = new PokeApiSync(new StatefullNextPokemonResolver(), pokeApiProxy, pokeRocketEndpointsProxy);

    }


    @Override
    public void addRoutesToCamelContext(CamelContext camelContext) throws Exception {
        camelContext.addRoutes(newPokeApiSyncRoutesRoute());
    }


    private RouteBuilder newPokeApiSyncRoutesRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                // TODO: finish retries and fail queue
                // String onFailToEndpoint = EndpointFactory.SedaPublishQueue(RouteConstants.EVENT_FAIL_QUEUE);
                // onException(Exception.class).handled(false).maximumRedeliveries( properties.getPokeRocketMaxRetries() ).delay(properties.getPokeRocketDelayBeforeRetry())
                //         .bean(ExchangeMessageAdapters.class, "NewPokeSyncFail").marshal(DataFormats.MESSAGE_FAIL_FORMAT)
                //         .to(onFailToEndpoint);

                from(timerEndpoint)
                    .log("Running timer")
                    .process(exchange -> pokeSync.syncNext())
                .end();
            }

        };
    }


    private void validatePollParameters(PollProperties pollProperties) throws SystemLevelException {
        if(pollProperties.getPollPeriod() < MIN_POLL_PERIOD) {
            // polling too often could get us banned from using PokeApi
            throw new SystemLevelException("pollPeriod < MIN_POLL_PERIOD. pollPeriod = "+pollProperties.getPollPeriod()+"\n");
        }
    }

}
