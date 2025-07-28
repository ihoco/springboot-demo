package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 查看所有图书
    @GetMapping
    public List<Book> getBooks(){

        return bookService.getAllBooks();
    }


    // 添加新图书
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title){
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/page")
    public Page<Book> getBooksByPage(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size
                                     ){
        Pageable pageable = PageRequest.of(page, size);
        return bookService.getBooksByPage(pageable);
    }

    // 删除图书
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
