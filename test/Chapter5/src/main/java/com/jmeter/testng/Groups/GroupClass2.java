package com.jmeter.testng.Groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupClass2 {
    public void stu21(){
        System.out.println("学生21");

    }
    public void stu22(){
        System.out.println("学生22");
    }
}
