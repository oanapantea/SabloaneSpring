package ro.uvt.sabloane.model.entity;

import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.Visitor;

import java.util.ArrayList;

public class Section implements Element {
    private String sectionTitle;
    ArrayList<Element> elements = new ArrayList<>();

    public Section(String sectionTitle, ArrayList<Element> elements) {
        this.sectionTitle = sectionTitle;
        this.elements = elements;
    }

    public Section(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public int add(Element element) {
        elements.add(element);
        return elements.indexOf(element);
    }

    public void remove(Element element) {
        elements.remove(element);
    }

    public Element getElement(int index) {
        return elements.get(index);
    }

    public void print() {
        System.out.println(sectionTitle);

        for (Element i : elements) {
            i.print();
        }
    }

    public void accept(Visitor visitor) {

        visitor.visit(this);

        for (Element elem : elements) {
            elem.accept(visitor);
        }

    }

}
