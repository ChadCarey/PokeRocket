package com.chad.portfolio.pokerocket.camel.routebuilders.constants;

import com.chad.portfolio.pokerocket.messages.EventSubscriptionFail;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.spi.DataFormat;

public class DataFormats {
    // DATA FORMATS
    public static final DataFormat MESSAGE_FAIL_FORMAT = new JacksonDataFormat(EventSubscriptionFail.class);

}
