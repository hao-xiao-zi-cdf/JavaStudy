package com.hao_xiao_zi.ssmp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao_xiao_zi.ssmp.controller.utils.R;
import com.hao_xiao_zi.ssmp.pojo.Book;
import com.hao_xiao_zi.ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 15:16
 */
@RestController//@ResponseBody+Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAllBook(){
        return new R(true,bookService.getAllBook());
    }

    @GetMapping("/{id}")
    public R getOneBookById(@PathVariable("id") Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("/{current}/{page}")
    public R getBookByPage(@PathVariable("current") Integer current, @PathVariable("page") Integer page){
        return new R(true,bookService.getPageBook(current, page));
    }

    @PostMapping
    public R saveBook(@RequestBody Book book){
        return new R(bookService.saveOrUpdate(book));
    }

    @DeleteMapping("/{id}")
    public R removeBookById(@PathVariable("id") Integer id){
        return new R(bookService.removeById(id));
    }

    @PutMapping
    public R updateBookById(@RequestBody Book book){
        return new R(bookService.saveOrUpdate(book));
    }
}
