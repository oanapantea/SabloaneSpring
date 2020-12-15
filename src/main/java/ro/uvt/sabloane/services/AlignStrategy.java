package ro.uvt.sabloane.services;

import ro.uvt.sabloane.model.entity.Context;
import ro.uvt.sabloane.model.entity.Paragraph;

public interface AlignStrategy{
    public void render(Paragraph p, Context c);

}
