package ro.uvt.sabloane.model.entity;

import lombok.NoArgsConstructor;
import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.Visitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor(force = true)
public class Book implements Element {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors;

    @Transient
    private TableOfContents tableOfContents;

    @OneToMany(targetEntity = BaseElement.class)
    private final List<Element> elements = new ArrayList<>();


    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public int add(Element element) {
        elements.add(element);
        return elements.indexOf(element);
    }

    public void print() {
        System.out.println(title);

        for (Author a : authors) {
            a.print();
        }

        for (Element e : elements) {
            e.print();
        }


    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element elem : elements) {
            elem.accept(visitor);
        }

    }

    public Book(Long id, String title, List<Author> authors, TableOfContents tableOfContents) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.tableOfContents = tableOfContents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public TableOfContents getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(TableOfContents tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(tableOfContents, book.tableOfContents) &&
                Objects.equals(elements, book.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, tableOfContents, elements);
    }
}