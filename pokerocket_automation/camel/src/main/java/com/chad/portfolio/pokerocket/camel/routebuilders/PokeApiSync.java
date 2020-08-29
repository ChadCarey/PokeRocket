package com.chad.portfolio.pokerocket.camel.routebuilders;

//import com.chad.portfolio.pokerocket.model.Pokemon;

import com.chad.portfolio.pokerocket.clients.pokeapi.adapters.PokeApiAdapters;
import com.chad.portfolio.pokerocket.clients.pokeapi.beans.PokeApiPokemon;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxy;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxyFactory;
import com.chad.portfolio.pokerocket.camel.factories.EndpointFactory;
import com.chad.portfolio.pokerocket.camel.routebuilders.constants.RouteConstants;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxy;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxyFactory;
import com.chad.portfolio.pokerocket.model.Pokemon;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokeApiSync implements RoutesBuilder {

    private static Logger log = LoggerFactory.getLogger(PokeApiSync.class);

    private final static String pokeApiUrl = "https://pokeapi.co/api/v2";
    private final static String pokerocketEndpointsUrl = "http://172.19.0.3:5000";
    private PokeApiProxy pokeApiProxy;
    private PokeRocketEndpointsProxy pokeRocketEndpointsProxy;

    public PokeApiSync() {
        pokeApiProxy = PokeApiProxyFactory.Create(pokeApiUrl);
        pokeRocketEndpointsProxy = PokeRocketEndpointsProxyFactory.Create(pokerocketEndpointsUrl);
    }

    @Override
    public void addRoutesToCamelContext(CamelContext camelContext) throws Exception {
        camelContext.addRoutes(newPokeApiSyncRoute());
    }

    private RouteBuilder newPokeApiSyncRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {

//                SystemProperties properties = SystemProperties.getInstance();
            //    String onFailToEndpoint = EndpointFactory.SedaPublishQueue(RouteConstants.EVENT_FAIL_QUEUE);

                String timerEndpoint = EndpointFactory.SimpleTimer(
                        1,1,1
                );
//                       properties.getPokeApiPollPeriod(),
//                       properties.getPokeApiPollDelay(),
//                       properties.getPokeApiPollRepeatCount());

//                 onException(Exception.class).handled(false).maximumRedeliveries( properties.getPokeRocketMaxRetries() ).delay(properties.getPokeRocketDelayBeforeRetry())
//                         .bean(ExchangeMessageAdapters.class, "eventMessageExchangeToEventSubscriptionFail").marshal(DataFormats.EVENT_FAIL_FORMAT)
//                         .to(onFailToEndpoint);

                  from(timerEndpoint)
                  .log("Running timer")
                   .process(new Processor() {
                       @Override
                       public void process(Exchange exchange) throws Exception {
                            // todo: get next pokemon id
                            PokeApiPokemon pokeApiPokemon = pokeApiProxy.getPokemonById(1);
                            Pokemon pokemon = PokeApiAdapters.FromPokeApi(pokeApiPokemon);
                            Integer dbId = pokeRocketEndpointsProxy.addPokemon(pokemon);
                            log.info("added pokemon with dbId: "+dbId);
                       }
                   })
                    .end();
            }
        };
    }
}
