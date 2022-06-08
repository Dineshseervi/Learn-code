package main.java.online.assisment.efficent;


import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
           // String val =new String( (md.digest(input.getBytes(StandardCharsets.UTF_8))));
           // System.out.println(val);

            String val2=toHexString(md.digest(input.getBytes(StandardCharsets.UTF_8)));
            System.out.println(val2);

            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(1,1);
            map.get(1);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
