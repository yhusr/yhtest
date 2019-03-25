package com.test.controller;

import com.test.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "/v1",description = "这是我的mysql的语句")
@RequestMapping("v1")
public class Demo {
    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/get/User/Count",method = RequestMethod.GET)
    @ApiOperation(value = "这是获取的用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个添加用户的请求",httpMethod = "POST")
    public int addUser(@RequestBody User user){
       return template.insert("addUser",user);
    }
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "更新用户信息",httpMethod = "POST")
    public int updatemysqlUser(@RequestBody User user){
        return template.update("updateUser",user);
    }
    @RequestMapping(value = "/delete/User",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个删除数据的请求",httpMethod = "POST")
    public int deletemyUser(@RequestBody User user){
        return template.delete("deleteUser",user);
    }

}
