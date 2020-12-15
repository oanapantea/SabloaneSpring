package ro.uvt.sabloane.model.entity;

import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.Visitor;

import java.awt.*;

public class ImageProxy implements Element {
    public String url;
    public Dimension dim;
    private Image realImage;

    public ImageProxy(String url){
        this.url = url;
    }

    private Image loadImage(){
        if(null == realImage){
            realImage = new Image(url);
        }
        return realImage;
    }

    public void print(){
        loadImage();
        realImage.print();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
