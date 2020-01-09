package net;

import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSocket {
    private static String ip=null;

    private static final Logger LOG= LoggerUtils.getLoggerEntity(TestSocket.class);

    public static void main(String[] args) {
    }

    public static String getLocalIp(){
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
