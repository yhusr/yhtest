package com.test.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String denger;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
