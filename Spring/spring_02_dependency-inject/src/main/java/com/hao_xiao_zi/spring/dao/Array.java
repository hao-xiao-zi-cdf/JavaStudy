package com.hao_xiao_zi.spring.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 19:04
 */
public class Array {
    private String[] str;

    private Name[] names;

    private List<Integer> list1;

    private List<Name> list2;

    private Set<String> set1;

    private Set<Name> set2;

    private Map<Integer,String> map1;

    private Map<Integer,Name> map2;


    public void setMap1(Map<Integer, String> map1) {
        this.map1 = map1;
    }

    public void setMap2(Map<Integer, Name> map2) {
        this.map2 = map2;
    }

    public void setSet1(Set<String> set1) {
        this.set1 = set1;
    }

    public void setSet2(Set<Name> set2) {
        this.set2 = set2;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public void setNames(Name[] names) {
        this.names = names;
    }

    public void setList1(List<Integer> list1) {
        this.list1 = list1;
    }

    public void setList2(List<Name> list2) {
        this.list2 = list2;
    }

    @Override
    public String toString() {
        return "Array{" +
                "str=" + Arrays.toString(str) +
                ", names=" + Arrays.toString(names) +
                ", list1=" + list1 +
                ", list2=" + list2 +
                ", set1=" + set1 +
                ", set2=" + set2 +
                ", map1=" + map1 +
                ", map2=" + map2 +
                '}';
    }
}
