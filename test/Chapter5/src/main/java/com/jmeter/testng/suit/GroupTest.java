package com.jmeter.testng.suit;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupTest {

    @Test(groups = "server")
    public void Grouptest1(){
        System.out.println("服务端");
    }
    @Test(groups = "client")
    public void Grouptest2(){
        System.out.println("客户端");
    }
    @BeforeGroups("server")
    public void BeforeGroup(){
        System.out.println("BeforeGroup运行之前");
    }
    @AfterGroups("server")
    public void AfterGroup(){
        System.out.println("AfterGroup运行之后");
    }
}
