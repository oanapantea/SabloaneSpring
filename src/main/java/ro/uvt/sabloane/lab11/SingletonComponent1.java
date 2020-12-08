package ro.uvt.sabloane.lab11;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SingletonComponent1 {
    public SingletonComponent1() {
        System.out.println("SingletonComponent::SingletonComponent = " + this);
    }

    public void operation() {
        System.out.println("Invoked SingletonComponent::operation() on " + this);
    }
}