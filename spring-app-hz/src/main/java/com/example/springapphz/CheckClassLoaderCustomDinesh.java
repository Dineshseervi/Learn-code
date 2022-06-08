package com.example.springapphz;

import com.example.springapphz.model.CustomList;
import com.sun.nio.zipfs.ZipFileStore;

import java.util.ArrayList;
import java.util.logging.*;

public class CheckClassLoaderCustomDinesh {

    public static void main(String[] args) {

        System.out.println(""+ ZipFileStore.class.getClassLoader());
        System.out.println(""+ ArrayList.class.getClassLoader());

        System.out.println(""+ CheckClassLoaderCustomDinesh.class.getClassLoader());
    }
}
