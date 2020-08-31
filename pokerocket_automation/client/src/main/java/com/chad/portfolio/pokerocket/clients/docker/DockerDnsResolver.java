package com.chad.portfolio.pokerocket.clients.docker;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.chad.portfolio.pokerocket.clients.DnsResolver;

public class DockerDnsResolver implements DnsResolver{

    @Override
    public String getIpFromAlias(String alias) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName(alias);
            String ipStr = ip.getHostAddress();
            return ipStr;
    }

}
