package com.test.cases;

import com.test.config.TestConfig;
import com.test.model.UpdateUserInfoCase;
import com.test.model.User;
import com.test.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息的接口测试")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase =sqlSession.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
        //发送请求
        int result = getResult(updateUserInfoCase);
        Thread.sleep(4000);
        //获取响应结果后比对结果
        User user =sqlSession.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);

        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        //设置请求方式
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        //设置请求参数
        JSONObject param = new JSONObject();
        param.put("id",updateUserInfoCase.getUserId());
        param.put("userName",updateUserInfoCase.getUserName());
        param.put("denger",updateUserInfoCase.getDenger());
        param.put("age",updateUserInfoCase.getAge());
        param.put("permission",updateUserInfoCase.getPermission());
        param.put("isDelete",updateUserInfoCase.getIsDelete());

        //设置消息头
        post.setHeader("content-type","application/json");
        //将参数信息添加方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookie
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        //开启请求
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //获取请求响应数据
        String updateResult = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(updateResult);
        int a =Integer.parseInt(updateResult);
        return a;

    }
}
