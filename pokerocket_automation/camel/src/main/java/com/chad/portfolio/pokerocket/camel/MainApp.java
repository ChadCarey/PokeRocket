package com.chad.portfolio.pokerocket.camel;

import java.util.Properties;

import com.chad.portfolio.pokerocket.camel.routebuilders.PokeApiSyncRoutes;
import com.chad.portfolio.pokerocket.camel.routebuilders.PollProperties;
import com.chad.portfolio.pokerocket.clients.DnsResolver;
import com.chad.portfolio.pokerocket.clients.docker.DockerDnsResolver;

import org.apache.camel.main.Main;


public class MainApp {

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        String pokeApiUrl = "https://pokeapi.co/api/v2";
        Integer pokerocketPort = 5000;
        DnsResolver resolver = new DockerDnsResolver();
        String pokerocketUrl = "http://"+resolver.getIpFromAlias("pokerocket_endpoints")+":"+pokerocketPort;
        PollProperties pollProperties = new PollProperties()
            .pollDelay(1)
            .pollPeriod(30000)
            .pollRepeatCount(0)
        ;


        main.configure().addRoutesBuilder(new PokeApiSyncRoutes(pokeApiUrl, pokerocketUrl, pollProperties));
        try {
            main.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
