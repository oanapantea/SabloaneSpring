package ro.uvt.sabloane.services;

import ro.uvt.sabloane.model.entity.Book;

public class DocumentManager {
    private static DocumentManager singleton; // = new DocumentManager();
    private Book book;


    public Book getBook() {
        return book;
    }

    public static DocumentManager getInstance(){
        if(singleton == null)
            singleton = new DocumentManager();

        return singleton;

    }

    public void setBook(Book book) {
        getInstance();
        if(this.book == null){
            this.book = book;
        }
    }
}
