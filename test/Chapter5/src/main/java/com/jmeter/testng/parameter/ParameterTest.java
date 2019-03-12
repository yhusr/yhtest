package com.jmeter.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters({"name","str"})
    public void Parameter(String name ,String str){
        System.out.println("/n name="+ name +";value="+str );
    }
}
