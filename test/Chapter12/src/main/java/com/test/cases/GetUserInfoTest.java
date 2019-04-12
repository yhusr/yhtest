package com.test.cases;

import com.test.config.TestConfig;
import com.test.model.GetUserInfoCase;
import com.test.model.User;
import com.test.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GetUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取用户信息的接口测试")
    public void getUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);
        //发送请求获取结果
        JSONArray resultJson = getJsonResult(getUserInfoCase);
        //验证结果
        Thread.sleep(2000);
        User user= sqlSession.selectOne(getUserInfoCase.getExpected(),getUserInfoCase);
        System.out.println("自己查库获取用户信息"+user.toString());
        List list = new ArrayList();
        list.add(user);
        JSONArray jsonArray = new JSONArray(list);
        System.out.println(resultJson);
        System.out.println(jsonArray);
        JSONArray jsonArray1 = new JSONArray(resultJson.getString(0));
        Assert.assertEquals(jsonArray.toString(),jsonArray1.toString());

    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {
        //设置发送请求方式
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        //设置请求参数
        JSONObject param = new JSONObject();
        param.put("id",getUserInfoCase.getUserId());
        //设置请求头信息
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookie
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        //运行post
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result =EntityUtils.toString(response.getEntity(),"utf-8");
        List paramlist = Arrays.asList(result);
        JSONArray jsonArray = new JSONArray(paramlist);
        System.out.println(jsonArray);
        return jsonArray;
    }
}
