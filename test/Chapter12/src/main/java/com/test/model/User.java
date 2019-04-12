package com.test.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String age;
    private String denger;
    private String password;
    private String permission;
    private String isDelete;
@Override
    public String toString(){
        return (
                "{id:"+id+","+
                "userName:"+userName+","+
                "age:"+age+","+
                "denger:"+denger+","+
                "password:"+password+","+
                "permission:"+permission+","+
                "isDelete:"+isDelete+"}"
                );
    }
}
