package com.jmeter.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class dataprovider {
    @Test(dataProvider = "data")
    public void test1(String name,int age){
        System.out.println("test1111:name:"+name+":value:"+age);
    }

    @Test(dataProvider = "data")
    public void test2(String name,int age){
        System.out.println("test2222:name:"+name+";value:"+age);
    }

    @DataProvider(name = "data")
    public Object[][] testdata(Method method){
        Object[][] ject=null;
        if(method.getName().equals("test1")){
                    ject = new Object[][]{
                    {"张三",30}
                    ,{"李四",40}
                    ,{"王五",50}
            };
        }else if(method.getName().equals("test2")){
                    ject = new Object[][]{
                    {"小刘",30}
                    ,{"小李",40}
                    ,{"小王",50}
            };
        }
        return ject;
    }
}
