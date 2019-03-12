package com.jmeter.testng.Groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupClass1 {
    public void stu11(){
        System.out.println("学生11");

    }
    public void stu12(){
        System.out.println("学生12");
    }

}
