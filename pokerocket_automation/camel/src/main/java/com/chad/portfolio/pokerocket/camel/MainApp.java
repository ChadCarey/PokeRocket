package com.chad.portfolio.pokerocket.camel;

import com.chad.portfolio.pokerocket.camel.routebuilders.PokeApiSyncRoutes;
import org.apache.camel.main.Main;


public class MainApp {

    public static void main(String[] args) {
        Main main = new Main();
        main.configure().addRoutesBuilder(new PokeApiSyncRoutes());
        try {
            main.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
