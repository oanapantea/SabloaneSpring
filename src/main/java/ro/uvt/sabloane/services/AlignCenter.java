package ro.uvt.sabloane.services;


import ro.uvt.sabloane.model.entity.Context;
import ro.uvt.sabloane.model.entity.Paragraph;

public class AlignCenter implements AlignStrategy {

    @Override
    public void render(Paragraph p, Context c) {
        System.out.println("Aligned with AlignCenter: " + p.getText());
    }
}