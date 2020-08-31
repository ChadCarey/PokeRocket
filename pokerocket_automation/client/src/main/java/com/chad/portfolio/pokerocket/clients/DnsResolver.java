package com.chad.portfolio.pokerocket.clients;
import java.net.UnknownHostException;


public interface DnsResolver {
    String getIpFromAlias(String alias) throws UnknownHostException;
}
