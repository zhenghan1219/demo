package com.zzh.exercise.designPattern.builder;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/4/14
 */
public class UserUse {

    public static void main(String[] args) {
        new User.UserBuilder("张","三");
        new User.UserBuilder("李","四").address("北京市西二旗").age(22);
    }
}
