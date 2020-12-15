package ro.uvt.sabloane.model.entity;

import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.Visitor;

public class Table implements Element {
    private String title;

    public void print()
    {
        //System.out.println("models.Table with title: " + this.title);
        System.out.println(this.title);
    }

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
