package com.hao_xiao_zi.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-29
 * Time: 21:23
 */
@SpringBootTest
public class MybatisPlusPluginTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test01(){
        //创建分页对象
        Page<User> page = new Page<>(1,3);
        mapper.selectPage(page, null);
        System.out.println(page);
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页内容：" + page.getRecords());
        System.out.println("总记录条数：" + page.getTotal());
        System.out.println("当前页记录条数" + page.getSize());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());
    }

    @Test
    public void test02(){
        Page<User> page = new Page<>(1,2);
        mapper.selectPageByAge(page,25);
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页内容：" + page.getRecords());
        System.out.println("总记录条数：" + page.getTotal());
        System.out.println("当前页记录条数" + page.getSize());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());
    }
}
