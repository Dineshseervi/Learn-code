package com.example.springapphz.config;

import java.util.*;

public class TestApp {

    public static void main(String[] args) {
        String requestPath="/Main/";

        System.out.println("val:"+requestPath.endsWith("/"));
        int lastIndex = requestPath.indexOf("/", 1);
        System.out.println("last index :"+lastIndex);

        String pathContext = requestPath.substring(1, requestPath.length());
        System.out.println("pathContext :"+pathContext);


    }
}
