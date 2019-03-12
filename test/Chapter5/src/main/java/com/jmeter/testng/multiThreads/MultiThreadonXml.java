package com.jmeter.testng.multiThreads;

import org.testng.annotations.Test;

public class MultiThreadonXml {
    @Test
    public void test1(){

        System.out.printf("thread %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){

        System.out.printf("thread %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){

        System.out.printf("thread %s%n",Thread.currentThread().getId());
    }
}
