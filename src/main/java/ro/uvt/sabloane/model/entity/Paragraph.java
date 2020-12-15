package ro.uvt.sabloane.model.entity;

import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.Visitor;
import ro.uvt.sabloane.services.AlignCenter;
import ro.uvt.sabloane.services.AlignStrategy;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy = new AlignCenter();
    public void print()
    {
        alignStrategy.render(this, new Context());
    }

    public Paragraph(String text) {
        this.text = text;
    }
    public void setAlignStrategy(AlignStrategy aS){
        this.alignStrategy = aS;
    }
    public String getText(){
        return this.text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
