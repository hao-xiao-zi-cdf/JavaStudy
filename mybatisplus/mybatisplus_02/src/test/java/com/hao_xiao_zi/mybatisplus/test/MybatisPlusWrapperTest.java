package com.hao_xiao_zi.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-29
 * Time: 16:32
 */
@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test01(){
        //使用条件构造器查询用户信息
        //创建条件构造器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //构造条件
        wrapper.likeRight("user_name","To").between("age",20,30)
                .isNotNull("email");
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //使用条件构造器封装排序规则
        //创建条件构造器
        //SELECT uid AS id,user_name AS name,age,email,is_delete FROM t_user WHERE is_delete=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //构造条件
        wrapper.orderByDesc("age").orderByAsc("uid");
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test03(){
        //使用查询条件构造器删除用户
        //创建条件构造器
        //UPDATE t_user SET is_delete=1 WHERE is_delete=0 AND (email IS NOT NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("email");
        int count = mapper.delete(wrapper);
        System.out.println("受影响行数：" + count);
    }

    @Test
    public void test04(){
        //使用查询条件构造器完成修改操作
        //UPDATE t_user SET user_name=? WHERE is_delete=0 AND (age >= ? AND user_name LIKE ?)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //条件构造器封装条件
        wrapper.ge("age",20).like("user_name","a");
        //user对象用来封装修改的内容，并指定要修改的字段
        User user = new User();
        user.setName("lisi");
        int count = mapper.update(user, wrapper);
        System.out.println("受影响行数：" + count);
    }

    @Test
    public void test05(){
        //设置条件优先级
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET user_name=? WHERE is_delete=0 AND (user_name LIKE ? AND (age >= ? OR email IS NULL))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //lambda表达式内的逻辑优先运算
        wrapper.like("user_name","a")
                        .and(i->i.ge("age",20).or().isNull("email"));
        User user = new User();
        user.setName("zhangsan");
        mapper.update(user,wrapper);
    }

    @Test
    public void test06(){
        //查询指定字段内容
        //SELECT user_name,age,email FROM t_user WHERE is_delete=0 AND (age >= ?)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //指定查询字段及其查询条件
        wrapper.select("user_name","age","email").ge("age",25);
        List<Map<String, Object>> maps = mapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07(){
        //子查询简单使用
        //查询id<=4的用户信息
        //SELECT uid AS id,user_name AS name,age,email,is_delete FROM t_user WHERE is_delete=0 AND (uid IN (select uid from t_user where uid <= 4))
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.inSql("uid","select uid from t_user where uid <= 4");
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test08(){
        //使用UpdateWrapper来完成用户信息更新
        //UpdateWrapper可以完成两件事：1.定义要修改的字段及其修改数据 2.构造修改条件
        //UPDATE t_user SET user_name=?,age=? WHERE is_delete=0 AND (user_name LIKE ? AND (age >= ? OR email IS NULL))
        UpdateWrapper<User> wrapper = new UpdateWrapper();
        //指定修改字段及其数据
        wrapper.set("user_name","张三").set("age",25);
        //构造条件
        wrapper.like("user_name","a")
                .and(i->i.ge("age",20).or().isNull("email"));
        int count = mapper.update(wrapper);
        System.out.println("受影响的行数：" + count);
    }

    @Test
    public void test09(){
        //模拟组装条件来进行用户信息查询
        String userName = "a";
        Integer minAge = null;
        Integer maxAge = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(userName)){
            //userName != null || userName != "" || userName != " "
            wrapper.like("user_name",userName);
        }
        if(minAge != null && minAge > 0){
            wrapper.ge("age",minAge);
        }
        if(maxAge != null){
            wrapper.le("age",maxAge);
        }
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //简化查询条件的组装
        String userName = "a";
        Integer minAge = 20;
        Integer maxAge = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(userName),"user_name",userName)
                .ge(minAge != null,"age",minAge)
                .le(maxAge != null,"age",maxAge);
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test11(){
        //使用LambdaQueryWrapper构造器可以轻松获取表中的字段名
        String userName = "a";
        Integer minAge = 20;
        Integer maxAge = null;
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //通过函数式接口可以访问实体类当中的属性，从而获取表中的字段名来作为参数值
        wrapper.like(StringUtils.isNotBlank(userName),User::getName,userName)
                .ge(minAge != null,User::getAge,minAge)
                .le(maxAge != null,User::getAge,maxAge);
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test12(){
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(User::getAge,28).set(User::getEmail,"test@qq.com");
        wrapper.like(User::getName,"a").and(i->i.ge(User::getAge,20).or()
                .isNull(User::getEmail));
        int update = mapper.update(wrapper);
        System.out.println(update);
    }
}
