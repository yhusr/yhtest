package com.jmeter.testng.multiThreads;

import org.testng.annotations.Test;

public class MultiThread {
    @Test(invocationCount = 10,threadPoolSize = 10)
    public void getThread(){
        System.out.println(1);
        System.out.printf("thread  %s%n",Thread.currentThread().getId());
    }
}
