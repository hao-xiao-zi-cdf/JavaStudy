package com.hao_xiao_zi.ssmp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hao_xiao_zi.ssmp.pojo.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 20:42
 */
public interface IBookService extends IService<Book> {

    /**
     * 获取所有书籍信息
     * @return 返回书籍信息列表
     */
    List<Book> getAllBook();

    /**
     * 使用分页插件查询书籍信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Book> getBookByPage(Integer pageNum,Integer pageSize);
}
