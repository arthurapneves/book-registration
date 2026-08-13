package com.bookregistration.book.registration.controllers;

import com.bookregistration.book.registration.entity.Books;
import com.bookregistration.book.registration.repository.BookListRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookListController {
    private final BookListRepository bookListRepository;

    public BookListController(BookListRepository bookListRepository){
        this.bookListRepository =  bookListRepository;

    }

    // Get all books (Read)
    @GetMapping
    public List<Books> getAllBooks(){
        return bookListRepository.findAll();
    }

    //Post a book list (Create)
    @PostMapping
    public Books createBook(@RequestBody Books books) {
        return bookListRepository.save(books);
    }

    //Get book by id (Read)
    @GetMapping("/{id}")
    public Books getBooksId(@PathVariable Integer id){
        return bookListRepository.findById((long) id).orElse(null);
    }

    //Update book by id (Update)
    @PutMapping("/{id}")
    public Books updateBook(@PathVariable Integer id, @RequestBody Books booksDetails) {
        Books books = bookListRepository.findById((long) id).orElse(null);
        if (books != null) {
            books.setName(booksDetails.getName());
            books.setNote(booksDetails.getNote());
            return bookListRepository.save(books);
        }
        return null;
    }
    //Update book note only (Partial Update)
    @PatchMapping("/{id}")
    public Books patchBook(@PathVariable Integer id, @RequestBody Books booksDetails) {
        Books books = bookListRepository.findById((long) id).orElse(null);
        if (books != null) {
            if (booksDetails.getName() != null) {
                books.setName(booksDetails.getName());
            }
            if (booksDetails.getNote() != null) {
                books.setNote(booksDetails.getNote());
            }
            return bookListRepository.save(books);
        }
        return null;
    }

    //Delete book by id (Delete)
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookListRepository.deleteById((long) id);
    }

}
