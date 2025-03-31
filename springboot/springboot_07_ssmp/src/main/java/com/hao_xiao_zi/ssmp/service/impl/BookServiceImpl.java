package com.hao_xiao_zi.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hao_xiao_zi.ssmp.pojo.Book;
import com.hao_xiao_zi.ssmp.service.BookService;
import com.hao_xiao_zi.ssmp.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author 34255
* @description 针对表【book】的数据库操作Service实现
* @createDate 2025-03-31 20:25:53
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




