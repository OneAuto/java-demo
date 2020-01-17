package utils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class JSONDemo {
    public static void main(String[] args) {

    }
}


class InterfaceRequest {
    //模拟发送接口
    //接口
    private final static String URL = "http://jw.nnxy.cn/app.do?method=authUser&xh=20181004095&pwd=fengge123";
    private final static String demo="http://jwxt.nnxy.edu.cn/app.do?method=getUserInfo&xh=20181004095";



    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //连接服务器
        URLConnection connection = connection(URL);

        System.out.println(connection.getURL());
        String jsonStr=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        jsonStr=br.readLine();
        System.out.println(jsonStr);
        JSONObject jsonObject= JSONObject.parseObject(jsonStr);
        String token= (String) jsonObject.get("token");
        System.out.println(token);
    }

    public static HttpURLConnection connection(String URL
    ) throws IOException {

        URL url = new URL(URL);
        URLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        ((HttpURLConnection) connection).setRequestMethod("GET");
        connection.setUseCaches(false);
        ((HttpURLConnection) connection).setInstanceFollowRedirects(false);
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded;charset=UTF-8");
        connection.connect();
        return (HttpURLConnection) connection;

    }
}