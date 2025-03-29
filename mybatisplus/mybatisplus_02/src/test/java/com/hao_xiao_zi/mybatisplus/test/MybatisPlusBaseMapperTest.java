package com.hao_xiao_zi.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisPlusBaseMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testSelectList(){
        //使用条件构造器查询用户信息
        //创建条件构造器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //构造条件
        wrapper.likeRight("user_name","To").between("age",20,30)
                .isNotNull("email");
        List<User> users = mapper.selectList(wrapper);
        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testInsert(){
//        错误原因：Field 'uid' doesn't have a default value
//        因为mybatis-plus默认会把id作为主键值，然后通过雪花算法为id字段赋值
//        这里uid不会被被识别为主键，自然不会有值，也就没有对id字段赋值

//        INSERT INTO t_user  ( id, name, age, email )  VALUES (  ?, ?, ?, ?  )
//        mybatis-plus上来首先会去扫描实体类，分析里面的属性，将属性名解析成对应字段user中为id属性，自然
//        被解析成id字段，但是表中没有该字段报错

//        INSERT INTO t_user ( user_name, age, email ) VALUES ( ?, ?, ? )
//        当属性名为驼峰命名字段为下划线时，mybatis-plus默认会将驼峰名转化为下划线的名字
        //根据user对象新增记录
        User user = new User();
        user.setName("hao_xiao_zi");
        user.setAge(23);
        user.setEmail("3425588767@qq.com");
        int count = mapper.insert(user);
        System.out.println(count);
        //获取插入的主键id值
        System.out.println(user.getId());
    }

    @Test
    public void testDelete(){
//        根据主键id值进行用户删除
//        DELETE FROM user WHERE id=?
//        int count = mapper.deleteById(1905801907567767553L);
//        System.out.println("受影响的行数为：" + count);
//        根据map集合中的条件删除用户
//        DELETE FROM user WHERE (name = ? AND age = ?)
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","张三");
//        map.put("age",23);
//        int count = mapper.deleteByMap(map);
//        System.out.println("受影响的行数为：" + count);
//        根据Collection集合批量删除用户
//        DELETE FROM user WHERE id IN ( ? , ? )
        List<Long> list = Arrays.asList(5L, 4L);
        int count = mapper.deleteBatchIds(list);
        System.out.println("受影响的行数为：" + count);
//        根据封装的user对象id属性进行条件删除
//        DELETE FROM user WHERE id=?
//        User user = new User();
//        user.setName("张三");
//        user.setAge(23);
//        user.setEmail("3425588767@qq.com");
//        int count = mapper.deleteById(user);
//        System.out.println("受影响的行数为：" + count);
    }

    @Test
    public void testUpdate(){
//        根据封装的user对象中的id属性对指定用户进行数据修改
//        UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(4L);
        user.setName("张三");
        user.setEmail("3425588767@qq.com");
        int count = mapper.updateById(user);
        System.out.println("受影响的行数为：" + count);
    }

    @Test
    public void testSelect(){
//        根据主键id查询用户信息
//        SELECT id,name,age,email FROM user WHERE id = ?
//        User user = mapper.selectById(1L);
//        System.out.println(user);
//        根据map集合里封装的条件查询用户
//        SELECT id,name,age,email FROM user WHERE (name = ? AND age = ?)
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","jack");
//        map.put("age",20);
//        List<User> users = mapper.selectByMap(map);
//        users.forEach(System.out::println);
//        根据Collection集合封装的数据批量查询
//        SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
//        List<Long> list = Arrays.asList(1L, 2L, 3L);
//        List<User> users = mapper.selectBatchIds(list);
//        users.forEach(System.out::println);
//        根据条件构造器封装的条件查询用户信息
//        SELECT id,name,age,email FROM user
//        List<User> users = mapper.selectList(null);
//        users.forEach(System.out::println);
//        mapper.selectMapById(1L);
        mapper.selectByName("jack");
    }
}
