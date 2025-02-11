package com.cdf.bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-11
 * Time: 21:39
 */
public class User {
    private String userName;
    private String password;
    private int age;
    private City city;

    public User(String userName, int age, String password) {
        this.userName = userName;
        this.age = age;
        this.password = password;
        city = new City("泉州","安溪县龙涓镇");
    }

    public String getUserName() {
        System.out.println("getUserName()执行了...");
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        System.out.println("getPassword()执行了...");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        System.out.println("getAge()执行了...");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail(){
        return "34@qq.com";
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
