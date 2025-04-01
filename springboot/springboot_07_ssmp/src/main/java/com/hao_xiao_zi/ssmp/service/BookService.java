package com.hao_xiao_zi.ssmp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao_xiao_zi.ssmp.pojo.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 34255
* @description 针对表【book】的数据库操作Service
* @createDate 2025-03-31 20:25:53
*/
public interface BookService extends IService<Book> {

    /**
     * 获取所有书籍
     * @return 返回所有书籍信息
     */
    List<Book> getAllBook();

    /**
     * 根据分页查询书籍信息
     * @return 书籍
     */
    Page<Book> getPageBook(Integer current,Integer page);
}
