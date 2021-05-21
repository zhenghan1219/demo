package com.zzh.exercise.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nicomama
 */
public class Student extends Person {
    String name;
    Integer age;
    String garde;
    boolean sex;

    public String getGarde() {
        return garde;
    }

    public void setGarde(String garde) {
        this.garde = garde;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
