package com.zzh.exercise.designPattern.builder;

/**
 * @Author: Zhenghan
 * @Description: *
 * ***User****类的构造方法是私有的。也就是说调用者不能直接创建User对象。
 * ****User****类的属性都是不可变的。所有的属性都添加了final修饰符，并且在构造方法中设置了值。并且，对外只提供getters方法。
 * Builder模式使用了链式调用。可读性更佳。
 * Builder的内部类构造方法中只接收必传的参数，并且该必传的参数适用了final修饰符
 * @Date: Create by 2021/4/14
 */
public class User {

    private final String firstName;     // 必传参数
    private final String lastName;      // 必传参数
    private final int age;              // 可选参数
    private final String phone;         // 可选参数
    private final String address;       // 可选参数
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    /**
     * 唯一可能存在的问题就是会产生多余的Builder对象，消耗内存
     * Builder模式是非线程安全的；
     * 所以如果要在Builder内部类中检查一个参数的合法性，必需要在对象创建完成之后再检查。
     * 即new User();之后再校验参数的正确性；
     */
    public static class UserBuilder{
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
