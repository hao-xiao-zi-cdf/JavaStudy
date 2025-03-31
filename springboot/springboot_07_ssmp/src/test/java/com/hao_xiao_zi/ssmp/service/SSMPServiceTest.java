package com.hao_xiao_zi.ssmp.service;

import com.hao_xiao_zi.ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-31
 * Time: 21:26
 */
@SpringBootTest
public class SSMPServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void test01(){
        Book book = new Book();
        book.setName("怪奇物语");
        book.setType("魔幻");
        book.setDescription("这是一部魔幻小说，后来被翻拍成美剧，一共拍了四季，今年要出第五季了");
        System.out.println(bookService.save(book));
    }

    @Test
    public void test02(){
        System.out.println(bookService.removeById(22));
    }

    @Test
    public void test03(){
        Book book = new Book();
        book.setId(22);
        book.setName("怪奇物语2");
        book.setType("魔幻");
        book.setDescription("这是一部魔幻小说，后来被翻拍成美剧，一共拍了四季，今年要出第五季了");
        bookService.saveOrUpdate(book);
    }

    @Test
    public void test04(){
        Book byId = bookService.getById(22);
        System.out.println(byId);
    }
}
