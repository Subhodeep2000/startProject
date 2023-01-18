package com.example.startProject.controller;

import com.example.startProject.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private HashMap<Integer, Book> bookHashMap = new HashMap<Integer, Book>();

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    // insertBook - Post - RequestBody
    // updateBook - Put - RequestBody
    // DeleteBook - Delete - Path Variable (BookId)
    // getBookDetails - Get - path Variable
    // getAllBooks - Get - Return Book List

    @PostMapping("insertBook")
    public ResponseEntity insertBook(@RequestBody Book book) {
        logger.info("Book Coming for Insertion : {}",book);
        if (bookHashMap.containsKey(book.getId())) {
            logger.error("Book Already Present.");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        bookHashMap.put(book.getId(), book);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("updateBook")
    public Book updateBook(@RequestBody Book book) {
        bookHashMap.put(book.getId(), book);
        return bookHashMap.get(book.getId());
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable("id") int bookId) {
        bookHashMap.remove(bookId);
        return "Book Deleted successfully";
    }

    @GetMapping("/book/{bookId}")
    public Book getBookByBookId(@PathVariable("bookId") int bookId) {
        logger.info("bookId Received : {}", bookId);
        return bookHashMap.get(bookId);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookHashMap.values().stream().collect(Collectors.toList());
    }

    @PatchMapping("/updateBookDetails/{bookId}")
    public Book updateBookDetails(@RequestBody Book book,@PathVariable("bookId") int bookId) {
        Book prevBookData = bookHashMap.get(bookId);
        if(book.getName() != null) prevBookData.setName(book.getName());
        if(book.getAuthor() != null) prevBookData.setAuthor(book.getAuthor());
        if(book.getCost() != 0) prevBookData.setCost(book.getCost());
        bookHashMap.put(bookId, prevBookData);
        return bookHashMap.get(book.getId());
    }
}
