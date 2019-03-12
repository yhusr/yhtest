package com.jmeter.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuitConfig {
    @BeforeSuite
      public void BeforeSuit(){
          System.out.println("BeforeSuit之前运行");
      }
      @AfterSuite
      public void AfterSuit(){
          System.out.println("AfterSuit之后运行");
      }
      @BeforeTest
      public void BeforeTest(){
          System.out.println("BeforeTest之前运行");
      }
    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest之后运行");
    }


}
