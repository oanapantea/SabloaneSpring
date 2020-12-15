package ro.uvt.sabloane.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.entity.Book;
import ro.uvt.sabloane.services.BookService;

@RestController
@OpenAPIDefinition
@RequestMapping("/books")
@Tag(name = "Books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookService.createBook(book);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Element> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);
    }
}
