package com.chad.portfolio.pokerocket.camel.factories;

public class EndpointFactory {

    public static String SimpleTimer(Integer period, Integer delay, Integer repeatCount) {
        return "timer://simpletimer?period="+period+"&delay="+delay+"&repeatCount="+repeatCount;
    }

    public static String SedaConsumerQueue(String queueName, Integer concurrentConsumers) {
        return String.format("seda:%s?concurrentConsumers=%d", queueName, concurrentConsumers);
    }


    public static String SedaPublishQueue(String queueName) {
        return String.format("seda:%s?", queueName);
    }
}
