package com.chad.portfolio.pokerocket.camel;

import com.chad.portfolio.pokerocket.camel.routebuilders.PokeApiSync;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

    private CamelContext camelContext;
    private RoutesBuilder pokeSync;

    public void run() throws Exception {
        pokeSync = new PokeApiSync();
        this.camelContext = new DefaultCamelContext();
        pokeSync.addRoutesToCamelContext(this.camelContext);
        camelContext.setTracing(true);
        camelContext.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    camelContext.stop();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        waitForStop();
    }

    public void waitForStop() {
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        try {
            mainApp.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
