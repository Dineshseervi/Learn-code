package main.java.basic.readwrite.march;

import java.util.List;

public class SubjectB {
    private String name;
    private List<String> chapterCollection;
    private double price;

    private AddressB address;

    public AddressB getAddress() {
        return address;
    }

    public void setAddress(AddressB address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChapterCollection() {
        return chapterCollection;
    }

    public void setChapterCollection(List<String> chapterCollection) {
        this.chapterCollection = chapterCollection;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
