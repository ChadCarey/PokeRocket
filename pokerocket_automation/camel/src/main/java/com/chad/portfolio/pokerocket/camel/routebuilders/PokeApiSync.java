package com.chad.portfolio.pokerocket.camel.routebuilders;

//import com.chad.portfolio.pokerocket.model.Pokemon;

import com.chad.portfolio.pokerocket.camel.SystemProperties;
import com.chad.portfolio.pokerocket.camel.factories.EndpointFactory;
import com.chad.portfolio.pokerocket.camel.routebuilders.constants.RouteConstants;
import com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi.PokeApiProxy;
import com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi.PokeApiProxyFactory;
import com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi.beans.PokeApiPokemon;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

public class PokeApiSync implements RoutesBuilder {

    private final static String pokeApiUrl = "https://pokeapi.co/api/v2";
    private PokeApiProxy pokeApiProxy;

    public PokeApiSync() {
        pokeApiProxy = PokeApiProxyFactory.Create(pokeApiUrl);
    }

    @Override
    public void addRoutesToCamelContext(CamelContext camelContext) throws Exception {
        camelContext.addRoutes(newPokeApiSyncRoute());
    }

    private RouteBuilder newPokeApiSyncRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                SystemProperties properties = SystemProperties.getInstance();
                String onFailToEndpoint = EndpointFactory.ActiveMq(RouteConstants.EVENT_FAIL_QUEUE);

                String timerEndpoint = EndpointFactory.SimpleTimer(
                        1,1,0
                );
//                        properties.getPokeApiPollPeriod(),
//                        properties.getPokeApiPollDelay(),
//                        properties.getPokeApiPollRepeatCount());

//                  onException(Exception.class).handled(false).maximumRedeliveries( properties.getPokeRocketMaxRetries() ).delay(properties.getPokeRocketDelayBeforeRetry())
//                          .bean(ExchangeMessageAdapters.class, "eventMessageExchangeToEventSubscriptionFail").marshal(DataFormats.EVENT_FAIL_FORMAT)
//                          .to(onFailToEndpoint);

                  from(timerEndpoint)
                          .log("gotit!")
//                    .process(new Processor() {
//                        @Override
//                        public void process(Exchange exchange) throws Exception {
//                            PokeApiPokemon pokeApiPokemon = pokeApiProxy.getPokemonById(1);
////                            Pokemon pokemon = PokeApiAdapter.FromPokeApi(pokeApiPokemon);
////                            exchange.getOut().setBody(pokemon);
//                        }
//                    })
                    .end();
            }
        };
    }
}
