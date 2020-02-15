package http;

import com.github.kevinsawicki.http.HttpRequest;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpTemplate {
    static final Logger LOG= LoggerUtils.getLoggerEntity(HttpTemplate.class);
    private final static String URL = "http://jw.nnxy.cn/app.do?method=authUser&xh=20181004095&pwd=fengge123";
    private final static String url="http://jwgl.sdust.edu.cn/app.do?method=getCjcx&xh=201801140926&xnxqid=";
    public static void main(String[] args) {
        String response= HttpRequest.get(URL).body();
        LOG.info("json：{}",response);
        JSONObject json=JSONObject.fromObject(response);
        String token= (String) json.get("token");

        try {
          HttpURLConnection conn= HttpRequest.get(url).getConnection();
          conn.setRequestProperty("token",token);
            BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            LOG.info("content：{}",in.readLine());
        } catch (HttpRequest.HttpRequestException | IOException e) {
            e.printStackTrace();
        }
    }

}
