package com.hao_xiao_zi.mybatisplus.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao_xiao_zi.mybatisplus.mapper.ProductMapper;
import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.Product;
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
    private UserMapper userMapper;
    
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01(){
        //创建分页对象
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page, null);
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
        userMapper.selectPageByAge(page,25);
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页内容：" + page.getRecords());
        System.out.println("总记录条数：" + page.getTotal());
        System.out.println("当前页记录条数" + page.getSize());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());
    }
    
    @Test
    public void test03(){
        //模拟修改冲突
        //小李进行商品价格查询
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的价格为：" + productLi.getPrice());

        //小王进行商品价格查询
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的价格为：" + productWang.getPrice());

        //小李进行商品价格修改
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        //小王进行商品价格修改
        productWang.setPrice(productWang.getPrice() - 30);
        int count = productMapper.updateById(productWang);
        if(count == 0){
            //操作失败
            Product product = productMapper.selectById(1);
            product.setPrice(product.getPrice() - 30);
            productMapper.updateById(product);
        }

        //老板进行商品价格查询
        Product productLao = productMapper.selectById(1);
        System.out.println("老板查询出来的价格为：" + productLao.getPrice());
    }
}
