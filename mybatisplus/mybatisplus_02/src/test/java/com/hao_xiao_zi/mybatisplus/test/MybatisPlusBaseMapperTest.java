package com.hao_xiao_zi.mybatisplus.test;

import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusBaseMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testSelectList(){
        List<User> users = mapper.selectList(null);
        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testInsert(){
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
//        List<Long> list = Arrays.asList(5L, 4L);
//        int count = mapper.deleteBatchIds(list);
//        System.out.println("受影响的行数为：" + count);
//        根据封装的user对象id属性进行条件删除
//        DELETE FROM user WHERE id=?
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("3425588767@qq.com");
        int count = mapper.deleteById(user);
        System.out.println("受影响的行数为：" + count);
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
