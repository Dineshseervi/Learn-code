package main.java.online.assisment.efficent;

import java.util.Optional;

public class TestOptionnal  {
    public static void main(String[] args) {
        Optional<String> val=Optional.ofNullable("value");
        if(val.isPresent())
        {
            System.out.println("val present");
        }
        else {
            System.out.println("empty");
        }
    }
}
