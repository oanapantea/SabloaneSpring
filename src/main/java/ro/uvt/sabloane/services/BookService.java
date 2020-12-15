package ro.uvt.sabloane.services;

import ro.uvt.sabloane.model.entity.Book;

public interface BookService {

    Book createBook(Book book);
    Book findBookById(Long id);

}
