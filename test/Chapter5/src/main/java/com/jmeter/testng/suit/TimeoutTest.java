package com.jmeter.testng.suit;

import org.testng.annotations.Test;

public class TimeoutTest {
    @Test(timeOut = 3000)//单位为毫秒
    public void TestSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }


    @Test(timeOut = 2000)
    public void TestFail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
