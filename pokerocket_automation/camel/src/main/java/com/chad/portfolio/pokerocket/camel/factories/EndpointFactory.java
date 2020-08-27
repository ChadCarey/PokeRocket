package com.chad.portfolio.pokerocket.camel.factories;

public class EndpointFactory {

    public static String SimpleTimer(Integer period, Integer delay, Integer repeatCount) {
        return "timer://simpletimer?period="+period+"&delay="+delay+"&repeatCount="+repeatCount;
    }

}
