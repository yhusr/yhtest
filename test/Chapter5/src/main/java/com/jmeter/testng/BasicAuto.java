package com.jmeter.testng;

import org.testng.annotations.*;

public class BasicAuto {
    @Test
    public void testCase1(){
        System.out.println("zheshiceshi");
    }
    @Test
    public void testCase2(){
        System.out.println("测试2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod在测试之前运行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod在测试之后");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforecalss这是在类运行之前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterclass这是在类运行之后运行的");
    }

    
}
