package com.bookstore.api.controller;

import com.bookstore.api.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    
    private List<Book> books = new ArrayList<>();
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookWithHeaders(@PathVariable Long id) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);

        return ResponseEntity.ok()
                .header("Custom-Header", "bookstore-header")
                .body(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        books.set(id, book);
        return book;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        books.remove(id);
        return "Book with ID " + id + " deleted";
    }
    
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return books.get(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "author", required = false) String author) {
        return books.stream()
                    .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                    (author == null || book.getAuthor().equalsIgnoreCase(author)))
                    .toList();
    }

}
