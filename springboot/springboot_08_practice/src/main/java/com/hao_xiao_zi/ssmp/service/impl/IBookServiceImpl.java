package com.hao_xiao_zi.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hao_xiao_zi.ssmp.mapper.BookMapper;
import com.hao_xiao_zi.ssmp.pojo.Book;
import com.hao_xiao_zi.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 20:43
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookMapper.selectList(null);
        return books;
    }

    @Override
    public Page<Book> getBookByPage(Integer pageNum, Integer pageSize) {
        Page<Book> page = bookMapper.selectPage(new Page(pageNum, pageSize), null);
        return page;
    }
}
