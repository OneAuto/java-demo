package http;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpTemplate {
    static final Logger LOG= LoggerUtils.getLoggerEntity(HttpTemplate.class);
    private final static String URL = "http://jw.nnxy.cn/app.do?method=authUser&xh=20181004095&pwd=fengge123";
    private final static String url="http://jw.nnxy.cn/app.do?method=getCjcx&xh=20181004095&xnxqid=2019-2020-1";
    public static void main(String[] args) {
        String response= HttpRequest.get(URL).body();
        LOG.info("请求返回json串:{}",response);

        JSONObject json=JSONObject.parseObject(response);
        String token= (String) json.get("token");
        LOG.info("token:{}",token);
        try {
          HttpURLConnection conn= HttpRequest.get(url).getConnection();
          conn.setRequestProperty("token",token);
            BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println(in.readLine());
        } catch (HttpRequest.HttpRequestException | IOException e) {
            e.printStackTrace();
        }
    }

}
