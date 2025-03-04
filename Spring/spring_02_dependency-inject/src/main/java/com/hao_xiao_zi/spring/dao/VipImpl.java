package com.hao_xiao_zi.spring.dao;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 18:07
 */
public class VipImpl {
    private int age1;
    private Integer age2;

    private boolean flag1;
    private Boolean flag2;

    private char word1;
    private Character word2;

    private String str;

    private Class clazz;

    private Num num;

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public void setWord1(char word1) {
        this.word1 = word1;
    }

    public void setWord2(Character word2) {
        this.word2 = word2;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setNum(Num num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "VipImpl{" +
                "age1=" + age1 +
                ", age2=" + age2 +
                ", flag1=" + flag1 +
                ", flag2=" + flag2 +
                ", word1=" + word1 +
                ", word2=" + word2 +
                ", str='" + str + '\'' +
                ", clazz=" + clazz +
                ", num=" + num +
                '}';
    }

    public String getStr() {
        return str;
    }
}
