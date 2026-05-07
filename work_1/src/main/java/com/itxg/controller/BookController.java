package com.itxg.controller;

import com.itxg.entity.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/hello")
    public String hello() {
        return "springboot ok";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return new Book(id, "Java程序设计", "张三", 59.9);
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        return "新增成功，图书名称：" + book.getName()
                + "，作者：" + book.getAuthor()
                + "，价格：" + book.getPrice();
    }
}