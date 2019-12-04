package main.java.collection.composite;

public class CompositeException extends RuntimeException {

    private String message;
    public CompositeException(String message)
    {
        super(message);
        this.message=message;
    }
}
