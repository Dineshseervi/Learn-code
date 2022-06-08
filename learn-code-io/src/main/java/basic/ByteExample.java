package main.java.basic;

import main.java.basic.readwrite.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteExample {

    public static void main(String[] args) {
        FileWriteReadSteamHelper bufferStreamExample=new FileWriteReadSteamHelper();
        bufferStreamExample.writeReadFileUsingFileStream();

    }


}
