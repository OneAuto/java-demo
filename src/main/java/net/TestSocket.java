package net;

import org.slf4j.Logger;
import utils.LoggerUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSocket {

    private static final Logger LOG= LoggerUtils.getLoggerEntity(TestSocket.class);

    public static void main(String[] args) {
        getLocalIp();
    }

    public static String getLocalIp(){
        String ip=null;
        try {
            InetAddress host=InetAddress.getLocalHost();
            ip=host.getHostAddress();
            LOG.info("本机ip：{}",ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
