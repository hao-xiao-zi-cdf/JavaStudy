package com.hao_xiao_zi.ssmp;

import com.hao_xiao_zi.ssmp.mapper.BookMapper;
import com.hao_xiao_zi.ssmp.service.IBookService;
import com.hao_xiao_zi.ssmp.testcase.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-06
 * Time: 10:23
 */
@SpringBootTest
public class ServiceTest {

    @Autowired
    private IBookService bookService;

    @Autowired
    private Book book;

    @Test
    public void testSave(){
        System.out.println(book);
//        bookService.saveOrUpdate(book);
    }
}
