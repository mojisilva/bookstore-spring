package com.moji.bookstore.service;

import com.moji.bookstore.entity.Book;
import com.moji.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public String createBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Book created with code " + book.getCode();
    }

    public Optional<Book> findBook(Long id){
        return bookRepository.findById(id);
    }

    public Iterable<Book> listBooks(){
        return bookRepository.findAll();
    }

    public String updateBook(@RequestBody Long id, Book book){
        bookRepository.findById(id).
            map(record ->{
                record.setName(book.getName());
                record.setPrice(book.getPrice());
                record.setCategory(book.getCategory());
                record.setQuantity(book.getQuantity());
                record.setImgUrl(book.getImgUrl());
                return ResponseEntity.ok().body(bookRepository.save(record));
            });
        return "Book updated whit code " + id;
    }
    public String deleteBook(Long id){
        bookRepository.findById(id);
        bookRepository.deleteById(id);
        return "Book deleted with code "+ id;
    }



}
