package com.test.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private String denger;
    private String password;
    private int permission;
    private int isDelete;
@Override
    public String toString(){
        return (
                "{id:"+id+","+
                "name:"+name+","+
                "age:"+age+","+
                "denger:"+denger+","+
                "password:"+password+","+
                "permission:"+permission+","+
                "isDelete:"+isDelete+"}"
                );
    }
}
