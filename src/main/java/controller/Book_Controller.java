package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.Book_Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookControl")
public class Book_Controller {

    @Autowired
    Book_Repository bookRepo;

    // List all the books
    @GetMapping("/books")
    public List<Book> getAllBooks () {
        System.out.println("Get all books!");

        List<Book> books = new ArrayList<>();
        bookRepo.findAll().forEach(books::add);

        return books;
    }

    // Create a new book
    @PostMapping("/books/create")
    public Book createBook (@RequestBody Book book) {
        Book newBook = bookRepo.save(new Book(book.getBook_name(), book.getType(), book.getProgress()));
        return newBook;
    }

    // Delete a book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {

        bookRepo.deleteById(id);

        return new ResponseEntity<>("Book has been deleted!", HttpStatus.OK);
    }

    // Delete all books
    @DeleteMapping
    public ResponseEntity<String> deleteAllBooks() {
        bookRepo.deleteAll();

        return new ResponseEntity<>("All books have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/books/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {

        Optional<Book> bookData = bookRepo.findById(id);

        if (bookData.isPresent()) {
            Book updateBook = bookData.get();
            updateBook.setBook_name(book.getBook_name());
            updateBook.setType(book.getType());
            updateBook.setProgress(book.getProgress());
            return new ResponseEntity<>(bookRepo.save(updateBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
