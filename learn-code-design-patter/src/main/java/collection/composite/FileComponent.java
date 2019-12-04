package main.java.collection.composite;

import java.util.Enumeration;
import java.util.Vector;

public class FileComponent extends FileSystemComponent {

    private long size;
    public FileComponent(String cName, long sz) {
        super(cName);
        size = sz;
    }
    public long getComponentSize() {
        return size;
    }
}//End of class

