package net;
import org.junit.Test;
import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

    private static final Logger LOG= LoggerUtils.getLoggerEntity(TestSocket.class);

    public static void main(String[] args) throws IOException {
    }


    /**
     * 获取ping信息返回打印
     * @throws IOException
     */

    public static void getPingLocalInfo() {

        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ping "+getLocalIp());
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @Test
    public void AddressTest() {
        try {
            InetAddress ia=InetAddress.getByName("www.baidu.com");
            System.out.println(ia);
            System.out.println(ia.getHostAddress());
            System.out.println(InetAddress.getLocalHost().getAddress());
            //获取ia对象所拥有的域名
            System.out.println(ia.getHostName());

            //获取ia对象所拥有的ip地址
            System.out.println(ia.getHostAddress());

            //是否可以到达此地址
           Boolean isTure= ia.isReachable(InetAddress.getLocalHost().getAddress().length);

            System.out.println(isTure);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void service() throws IOException {
        ServerSocket ss=new ServerSocket(8080);
        Socket s=ss.accept();
        InputStream is=s.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        while (br.read()!=-1){
            LOG.info("收到客户端信息：{}",br.readLine());
        }

        s.close();
        ss.close();
    }

    @Test
    public void client() throws IOException {
        Socket s=new Socket(InetAddress.getLocalHost().getHostAddress(),8080);
        LOG.info("客户端：{}",InetAddress.getLocalHost().getHostAddress());
        OutputStream os=s.getOutputStream();
        os.write("你好！我是客户端！".getBytes());

    }
}
