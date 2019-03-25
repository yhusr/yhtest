package com.test.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String name;
    private String password;
    private String denger;
    private int age;
    private int permission;
    private int isDelete;
    private String expected;
}
