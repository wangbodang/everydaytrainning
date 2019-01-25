package common.httpclient;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class HttpClientTest2 {

    @Test
    public void testHttpClient(){

        CookieStore cookieStore = new BasicCookieStore();

        // 创建Httpclient对象
        //CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //返回串
        String resultString = "";
        CloseableHttpResponse response = null;

        String url = "http://127.0.0.1:9090/tags-demo/getbooklist";
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);

            //添加参数
            builder.addParameter("test", "Fook");
            builder.addParameter("fuck", "fak");

            //生成uri
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            //设置header
            httpGet.setHeader("Cookie", "jeesite.session.id=053f1b6ce8b84b30a74dc5a7515c7bbc;fuck=fak");

            // 执行请求
            response = httpclient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");

                List<Cookie> cookies = cookieStore.getCookies();
                for(Cookie c:cookies) {
                    System.out.println("-> key:"+c.getName()+", value:"+c.getValue());
                }


            }

            //输出
            System.out.println(resultString);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
