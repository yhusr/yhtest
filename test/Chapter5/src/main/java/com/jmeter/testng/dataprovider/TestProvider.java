package com.jmeter.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestProvider {
    @Test(dataProvider = "data")
    public void dataPro(String name ,int age){
        System.out.println("name="+name+";age="+age);
    }
    @DataProvider(name="data")
    public Object[][] set(){
        Object[][] ject = new Object[][]{
                {"张三",10},
                {"lisi",20}
        };
        return ject;
    }
}
