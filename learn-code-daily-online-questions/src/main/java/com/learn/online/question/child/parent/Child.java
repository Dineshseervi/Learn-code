package com.learn.online.question.child.parent;

import java.io.IOException;
import java.nio.file.FileSystemException;

public class Child extends Parent{

    @Override
    public void printName() throws IOException {
        super.printName();
    }
}
