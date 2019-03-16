package com.test.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ResourceBundle;

public class HttpPostFormat {
    String url;
    ResourceBundle bundle;
    private HttpResponse response;
    private CookieStore cookieStore;
    @BeforeTest
    public void getHttpCookies() {
        bundle = ResourceBundle.getBundle("CookiesFormat");
        url= bundle.getString("test.url");

    }
    @Test
    public void TestGet() throws IOException {
        String road = bundle.getString("get.test.load");
        HttpGet get = new HttpGet(this.url+road);
        DefaultHttpClient client = new DefaultHttpClient();
        this.response = client.execute(get);

        String st = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(st);

        cookieStore = client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name="+name+"; value="+value);
        }
    }
    @Test(dependsOnMethods = {"TestGet"})
    public void postCookies() throws IOException {
        //获取请求地址及路径
        String road = bundle.getString("test.post.with.cookies");
        //拼接完整的地址
        String uri = this.url+road;
        //声明一个客户端client地址
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个post方法
        HttpPost post = new HttpPost(uri);
        //设置post方法中的header内容
        post.setHeader("content-type","application/json");
        //设置post方法中的cookie
        client.setCookieStore(this.cookieStore);
        //获取请求中的json内容
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","huhansan");
        jsonObject.put("age","18");
        //json内容放入post方法中
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
        post.setEntity(entity);
        //执行post方法
        HttpResponse response = client.execute(post);

        //获取post执行后的响应结果
        String result = EntityUtils.toString(response.getEntity(),"utf-8");

        //验证响应结果是否与预期一致
        JSONObject js = new JSONObject(result);
        String huhansan = (String)js.get("huhansan");
        int status = (Integer) js.get("status");
        Assert.assertEquals(status,1);
        Assert.assertEquals(huhansan,"success");
    }
}
