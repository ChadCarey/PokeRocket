package com.chad.portfolio.pokerocket.camel.routebuilders;

//import com.chad.portfolio.pokerocket.model.Pokemon;

import com.chad.portfolio.pokerocket.PokeApiSync;
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

    private final static String pokeApiUrl = "https://pokeapi.co/api/v2";
    private final static String pokerocketEndpointsUrl = "http://172.19.0.3:5000";

    private PokeApiSync pokeSync;
    private PokeApiProxy pokeApiProxy;
    private PokeRocketEndpointsProxy pokeRocketEndpointsProxy;

    public PokeApiSyncRoutes() {
        pokeApiProxy = PokeApiProxyFactory.Create(pokeApiUrl);
        pokeRocketEndpointsProxy = PokeRocketEndpointsProxyFactory.Create(pokerocketEndpointsUrl);
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

//                SystemProperties properties = SystemProperties.getInstance();
            //    String onFailToEndpoint = EndpointFactory.SedaPublishQueue(RouteConstants.EVENT_FAIL_QUEUE);

                String timerEndpoint = EndpointFactory.SimpleTimer(
                        10000,1,10
                );
//                       properties.getPokeApiPollPeriod(),
//                       properties.getPokeApiPollDelay(),
//                       properties.getPokeApiPollRepeatCount());

//                 onException(Exception.class).handled(false).maximumRedeliveries( properties.getPokeRocketMaxRetries() ).delay(properties.getPokeRocketDelayBeforeRetry())
//                         .bean(ExchangeMessageAdapters.class, "eventMessageExchangeToEventSubscriptionFail").marshal(DataFormats.EVENT_FAIL_FORMAT)
//                         .to(onFailToEndpoint);

                from(timerEndpoint)
                    .log("Running timer")
                    .process(exchange -> pokeSync.syncNext())
                .end();
            }
        };
    }
}
