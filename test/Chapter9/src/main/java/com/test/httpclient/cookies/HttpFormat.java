package com.test.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class HttpFormat {
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
    public void TestWithCookies() throws IOException {

        //放入cookie后的请求
        String withCookies = this.bundle.getString("test.get.with.cookies");
        HttpGet get = new HttpGet(this.url+withCookies);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode==200){
            String st = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(st);
        }
    }
}
