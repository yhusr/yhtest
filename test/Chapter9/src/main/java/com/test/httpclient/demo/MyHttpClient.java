package com.test.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        String str;
        HttpGet get = new HttpGet("https://www.baidu.com");
        HttpClient cl = new DefaultHttpClient();
        //这个是用来执行get方法的
        HttpResponse response = cl.execute(get);
        //获取并转换为string数据
        str = EntityUtils.toString(response.getEntity(),"utf8");
        System.out.println(str);
    }


}
