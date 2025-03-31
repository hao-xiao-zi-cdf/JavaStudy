package com.hao_xiao_zi.ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao_xiao_zi.ssmp.mapper.BookMapper;
import com.hao_xiao_zi.ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SSMPApplicationTests {

    @Autowired
    private BookMapper mapper;

    @Test
    public void testSelectBookById(){
        Book book = mapper.selectById(1);
        System.out.println(book);
    }

    @Test
    public void testSelectAllBook(){
        QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
        wrapper.ge("id",5);
        List<Book> books = mapper.selectList(wrapper);
        books.forEach(System.out::println);
    }

    @Test
    public void testInsertBook(){
        Book book = new Book();
        book.setName("怪奇物语");
        book.setType("魔幻");
        book.setDescription("这是一部魔幻小说，后来被翻拍成美剧，一共拍了四季，今年要出第五季了");
        int count = mapper.insert(book);
        System.out.println("一共成功插入记录：" + count);
    }

    @Test
    public void testDeleteBookById(){
        int count = mapper.deleteById(21);
    }

    @Test
    public void testUpdateBookById(){
        Book book = new Book();
        book.setId(21);
        book.setName("怪奇物语2");
        book.setType("魔幻1");
        book.setDescription("这是一部魔幻小说，后来被翻拍成美剧，一共拍了四季，今年要出第五季了1");
        int count = mapper.updateById(book);
    }

    @Test
    public void testSelectBookByPage(){
        //创建分页对象
        Page<Book> page = new Page<>(1,10);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("id");
        mapper.selectPage(page,wrapper);
    }

}
