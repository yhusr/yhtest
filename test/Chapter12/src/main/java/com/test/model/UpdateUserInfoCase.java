package com.test.model;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    private int id;
    private int userId;
    private String userName;
    private String denger;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
