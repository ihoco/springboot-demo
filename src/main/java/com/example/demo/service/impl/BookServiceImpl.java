package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    // 新增方法实现
    @Override
    public List<Book> searchBooksByTitle(String title){
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public Page<Book> getBooksByPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
