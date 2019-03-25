package com.test.server;

import com.test.bean.GetUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我的post请求")
@RequestMapping(value = "/v1")
public class MyPostMethod {
    private static Cookie cookie;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "这是我的post请求方法",httpMethod = "POST")

    public String postWithCookies(HttpServletResponse response, @RequestParam(value = "userName",required = true) String username,@RequestParam(value = "password",required = true) String password){

        if("wangying".equals(username) && "123456".equals(password)){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "param are right";
        }
        return "you are wrong";
    }


    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个需要获取参数的请求",httpMethod = "POST")
    public String getwithuser(HttpServletRequest request, @RequestBody GetUser getUser){
            Cookie[] cookies = request.getCookies();
            GetUser gu;
            for(Cookie coo:cookies){
                if(coo.getName().equals("login") && coo.getValue().equals("true")
                   && getUser.getUserName().equals("wangying") && getUser.getPassword().equals("123456")){
                        gu = new GetUser();
                        gu.setName("lisi");
                        gu.setAge("32");
                        gu.setSex("女");
                        return gu.toString();
                }
            }
            return "参数不合法";
    }
}
