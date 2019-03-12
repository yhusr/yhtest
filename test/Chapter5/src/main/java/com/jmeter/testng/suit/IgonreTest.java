package com.jmeter.testng.suit;

import org.testng.annotations.Test;

public class IgonreTest
{
    @Test
    public void ignore1(){
        System.out.println("ignore1 执行");
    }
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行");
    }
}
