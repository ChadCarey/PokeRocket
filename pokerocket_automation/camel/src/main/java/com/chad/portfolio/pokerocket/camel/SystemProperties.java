/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chad.portfolio.pokerocket.camel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;

public class SystemProperties {

    private final static Logger log = LoggerFactory.getLogger(SystemProperties.class);

    private final static SystemProperties INSTANCE = new SystemProperties();

    private static final String BROKER_URL_PID = "external.brokerUrl";
    private static final String BROKER_USER_PID = "broker.username";
    private static final String BROKER_PASSWORD_PID = "broker.password";
    private static final String BROKER_MAX_CONNECTIONS_PID = "broker.maximumActiveSessionsPerConnection";
    private static final String MAX_ACTIVE_SESSIONS_PER_CONNECTION_PID = "broker.maxConnections";
    private static final String POKE_ROCKET_MAX_RETRIES_PID = "pokerocket.maxRetries";
    private static final String POKE_ROCKET_RETRY_DELAY_PID = "pokerocket.delayBeforeRetry";
    private static final String POKE_API_POLL_REPEAT_COUNT_PID = "pokerocket.poll.repeatCount";
    private static final String POKE_API_POLL_PERIOD_PID = "pokerocket.poll.period";
    private static final String POKE_API_POLL_DELAY_PID = "pokerocket.poll.delay";

    private Dictionary<String, ?> properties;

    private SystemProperties() {

    }

    public static SystemProperties getInstance() {
        return INSTANCE;
    }


    public void loadConfiguration(Dictionary<String, ?> properties) {
        this.properties = properties;
    }

    public String getBrokerUrl() {
        String brokerUrl = (String) properties.get(BROKER_URL_PID);
        return brokerUrl;
    }

    public String getBrokerUsername() {
        String brokerUsername = (String) properties.get(BROKER_USER_PID);
        return brokerUsername;
    }

    public String getBrokerPassword() {
        String brokerPassword = (String) properties.get(BROKER_PASSWORD_PID);
        return brokerPassword;
    }

    public Integer getBrokerMaxConnections() {
        Integer brokerMaxConnections = Integer.valueOf((String) properties.get(BROKER_MAX_CONNECTIONS_PID));
        return brokerMaxConnections;
    }

    public Integer getMaxActiveSessionsPerConnection() {
        Integer maxActiveSessionsPerConnection = Integer.valueOf((String) properties.get(MAX_ACTIVE_SESSIONS_PER_CONNECTION_PID));
        return maxActiveSessionsPerConnection;
    }

    public Integer getPokeRocketMaxRetries() {
        Integer pokeRocketMaxRetries = Integer.valueOf((String) properties.get(POKE_ROCKET_MAX_RETRIES_PID));
        return pokeRocketMaxRetries;
    }

    public Long getPokeRocketDelayBeforeRetry() {
        Long pokeRocketDelayBeforeRetry = Long.valueOf((String) properties.get(POKE_ROCKET_MAX_RETRIES_PID));
        return pokeRocketDelayBeforeRetry;
    }

    public Integer getPokeApiPollRepeatCount() {
        Integer pokeApiPollRepeat = Integer.valueOf((String) properties.get(POKE_API_POLL_REPEAT_COUNT_PID));
        return pokeApiPollRepeat;
    }

    public Integer getPokeApiPollPeriod() {
        Integer pokeApiPollPeriod = Integer.valueOf((String) properties.get(POKE_API_POLL_PERIOD_PID));
        return pokeApiPollPeriod;
    }

    public Integer getPokeApiPollDelay() {
        Integer pokeApiPollDelay = Integer.valueOf((String) properties.get(POKE_API_POLL_DELAY_PID));
        return pokeApiPollDelay;
    }
}