package com.gogettergeeks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gogettergeeks.jackson.JsonUtil;
import com.gogettergeeks.jackson.model.Student;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student s1 = new Student();
        s1.setStudentId("1");
        s1.setRollNumber(10);
        s1.setName("John");

        JsonUtil<Student> studentJsonUtil = new JsonUtil<>();
        String s1Json = studentJsonUtil.toJson(s1);
        System.out.println(s1Json);
    }
}
