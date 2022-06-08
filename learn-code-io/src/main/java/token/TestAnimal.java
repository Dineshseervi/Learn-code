package main.java.token;

import java.util.function.Consumer;
import java.util.function.Function;

public class TestAnimal {

    static final Function<String, String> toUpperCase = (String::toUpperCase);
    public static void main(String[] args) {
        String sub="dineshseervi_at_fico.com";
        Consumer<String> stringConsumer=(s)->{
            System.out.println(s.toUpperCase());
        };
        stringConsumer.accept("dinesh");
        stringConsumer.accept("seervi");
        System.out.println(""+toUpperCase.apply("dinesh seervi"));
    }
}
