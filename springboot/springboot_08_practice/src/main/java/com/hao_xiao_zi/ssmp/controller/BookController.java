package com.hao_xiao_zi.ssmp.controller;

import com.hao_xiao_zi.ssmp.controller.utils.R;
import com.hao_xiao_zi.ssmp.pojo.Book;
import com.hao_xiao_zi.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 20:44
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/{id}")
    public R getOneBookById(@PathVariable("id") Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping
    public R getAllBook(){
        return new R(true,bookService.getAllBook());
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public R getBookByPage(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize){
        return new R(true,bookService.getBookByPage(pageNum, pageSize));
    }

    @PostMapping
    public R saveBook(@RequestBody Book book){
        return new R(bookService.saveOrUpdate(book));
    }

    @PutMapping
    public R updateBook(@RequestBody Book book){
        return new R(bookService.saveOrUpdate(book));
    }

    @DeleteMapping("/{id}")
    public R removeBookById(@PathVariable("id") Integer id){
        return new R(bookService.removeById(id));
    }
}
