package ro.uvt.sabloane.services;

import ro.uvt.sabloane.model.entity.*;

public class OpenCommand implements Command {

    public OpenCommand() {

    }

    @Override
    public void execute() {

        Book book1 = new Book("TitleBook");

        Author a1 = new Author("Author1");
        Author a2 = new Author("Author2");
        book1.addAuthor(a1);
        book1.addAuthor(a2);

        Section cap1 = new Section("Chapter 1");
        Paragraph paragraph1 = new Paragraph("Paragraph 1");
        cap1.add(paragraph1);
        Paragraph paragraph2 = new Paragraph("Paragraph 2");
        cap1.add(paragraph2);
        Paragraph paragraph3 = new Paragraph("Paragraph 3");
        cap1.add(paragraph3);
        book1.add(cap1);

        Table t1 = new Table("Table1");
        book1.add(t1);

        Image im = new Image("Image1");
        book1.add(im);

        System.out.println("Opening...");
        DocumentManager.getInstance().setBook(book1);
    }
}