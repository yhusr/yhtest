package com.jmeter.testng.dependon;

import org.testng.annotations.Test;

public class Depend {
    @Test
    public void DependTest1(){
        System.out.println("这是第一个测试");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"DependTest1"})
    public void DependTest2(){
        System.out.println("这是第二个测试");
    }
}
