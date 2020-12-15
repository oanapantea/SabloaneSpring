package ro.uvt.sabloane.model.entity;

import ro.uvt.sabloane.model.Element;
import ro.uvt.sabloane.model.Visitor;

import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String imageName;
    private long time;
    public Image(String name) {
        time = System.currentTimeMillis();
        imageName = name;
        try {
            //System.out.println("models.Image is being delayed: \n");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print()
    {
        //System.out.println("models.Image with name: " + this.imageName);
        System.out.println(this.imageName);

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
