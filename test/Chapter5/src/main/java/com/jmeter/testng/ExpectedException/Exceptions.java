package com.jmeter.testng.ExpectedException;

import org.testng.annotations.Test;

public class Exceptions {
    @Test(expectedExceptions = RuntimeException.class)
    public void ExceptionFail(){
        System.out.println("这是一个失败的异常测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void ExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
