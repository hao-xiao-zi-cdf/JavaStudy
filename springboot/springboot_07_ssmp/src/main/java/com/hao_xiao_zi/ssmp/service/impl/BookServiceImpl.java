package com.hao_xiao_zi.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hao_xiao_zi.ssmp.pojo.Book;
import com.hao_xiao_zi.ssmp.service.BookService;
import com.hao_xiao_zi.ssmp.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 34255
* @description 针对表【book】的数据库操作Service实现
* @createDate 2025-03-31 20:25:53
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookMapper.selectList(null);
        return books;
    }

    @Override
    public Page<Book> getPageBook(Integer current, Integer page) {
        Page<Book> pageBook = new Page<>(current,page);
        Page<Book> bookPage = bookMapper.selectPage(pageBook, null);
        return bookPage;
    }
}




