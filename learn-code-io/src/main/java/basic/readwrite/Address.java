package main.java.basic.readwrite;

import java.util.ArrayList;
import java.util.List;

public class Address extends RootAddress{
    private final List<String> address = new ArrayList<>();

    public List<String> getAddress() {
        return address;
    }

}
