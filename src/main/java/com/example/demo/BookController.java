package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // 查看所有图书
    @GetMapping("/books")
    public List<Book> getBooks(){
        return books;
    }


    // 添加新图书
    @PostMapping("/books")
    public String addBook(@RequestBody Book book){
        books.add(book);
        return "Book added: " + book.getTitle();
    }
}
