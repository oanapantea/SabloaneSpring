package ro.uvt.sabloane.model.entity;

import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.Visitor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BaseElement implements Element {

    @Id
    private String id;

    @Override
    public void print() {

    }

    @Override
    public void accept(Visitor visitor) {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
