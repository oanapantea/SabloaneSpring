package ro.uvt.sabloane.services.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.uvt.sabloane.model.entity.Book;
import ro.uvt.sabloane.repository.BookRepository;
import ro.uvt.sabloane.services.BookService;

import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        LOGGER.info("Creating Book " + book.getId());
        Book bookNew = bookRepository.save(book);

        return bookNew;
    }

    @Override
    public Book findBookById(Long id) {
        LOGGER.info("Searching for the Book with the following ID:" + id);

        Book book = bookRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Book not found with the following ID: " + id ));

        return book;
    }


}
