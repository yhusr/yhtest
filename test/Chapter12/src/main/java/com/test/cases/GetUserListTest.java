package com.test.cases;

import com.test.config.TestConfig;
import com.test.model.GetUserListCase;
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
import java.util.List;


public class GetUserListTest {
    @Test(dependsOnGroups = "loginTrue", description = "获取用户列表的接口测试")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase", 1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);
        //发送请求获取结果
        JSONArray result = getJsonResult(getUserListCase);
        //验证结果
        List<User> userList = sqlSession.selectList(getUserListCase.getExpected(),getUserListCase);
        for (User u : userList) {
            System.out.println("获取的user：" + u.toString());
        }
        JSONArray userListJson = new JSONArray(userList);
        Assert.assertEquals(userListJson.length(), result.length());
        for (int i = 0; i < result.length(); i++) {
            JSONObject expect = (JSONObject) result.get(i);
            JSONObject actual = (JSONObject) userListJson.get(i);
            Assert.assertEquals(expect.toString(), actual.toString());
        }
    }

    private JSONArray getJsonResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("denger",getUserListCase.getDenger());
        param.put("age",getUserListCase.getAge());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String str = EntityUtils.toString(response.getEntity(),"utf-8");

        JSONArray jsonArray = new JSONArray(str);
        return jsonArray;
    }
}

