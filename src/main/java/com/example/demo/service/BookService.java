package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    List<Book> getAllBooks();

    Book addBook(Book book);


    // 新增： 根据标题模糊搜索图书
    List<Book> searchBooksByTitle(String title);

    Page<Book> getBooksByPage(Pageable pageable);

    //  新增删除图书的方法声明
    void deleteBook(Long id);

}



