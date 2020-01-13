package net;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSocket {

    private static final Logger LOG= LoggerUtils.getLoggerEntity(TestSocket.class);

    public static void main(String[] args) throws IOException {
        getPingLocalInfo();
    }

    /**
     * 获取ping信息返回打印
     * @throws IOException
     */
    public static void getPingLocalInfo() throws IOException {

        Process p = Runtime.getRuntime().exec("ping "+getLocalIp());
        try (BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));){

            //造流，对流进行操作
            LOG.info("本次Ping返回的消息：");
            while(br.read()!=-1){
                LOG.info(br.readLine()+"\r");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
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
