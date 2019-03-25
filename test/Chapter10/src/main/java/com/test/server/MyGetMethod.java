package com.test.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的请求方法")
public class MyGetMethod {
    @RequestMapping(value="/getCookies",method = RequestMethod.GET )
    @ApiOperation(value="这是一个带cookie的请求",httpMethod = "GET")
    public String get(HttpServletResponse response){
            //HttpServerletRequest 装请求信息的类
            //HttpServerletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
            return "no parameter for get request";
        }


    /**
     * 要求客户端必须携带cookies信息发送请求
     * 这是一个需要携带cookies信息的get请求
     * */
    @RequestMapping(value = "/getwithcookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端必须携带cookies信息发送请求",httpMethod = "GET")
    public String getWithcookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "必须携带cookies信息来";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜你携带cookies信息成功";
            }
        }
        return "必须携带cookies信息来";
    }
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value="这是一个携带参数的get请求",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> mapList = new HashMap<String, Integer>();
        mapList.put("方便面",1);
        mapList.put("羽绒服",1000);
        mapList.put("茶叶",500);
        mapList.put("洗发水",70);
        return mapList;
    }
    /**
     * 第二种需要带参数的get请求
     * url=ip:port/get/with/param/10/20
     * */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value="这是第二种携带参数的请求",httpMethod = "GET")
    public Map<String,Integer> getParamList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> mapList = new HashMap<String, Integer>();
        mapList.put("方便面",1);
        mapList.put("羽绒服",1000);
        mapList.put("茶叶",500);
        mapList.put("洗发水",70);
        return mapList;
    }
}
