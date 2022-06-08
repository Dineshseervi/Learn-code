package com.test.learn;

public class TestStrinngEndWith {

    public static String removeEnd(String str, String remove) {
        if (str!=null && remove!=null) {
            return str.endsWith(remove) ? str.substring(0, str.length() - remove.length()) : str;
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        String q="/services/myJavaService1";
        String val=removeEnd(q, "Service");
        System.out.println("val:"+val);
        System.out.println("val:"+(val+"/").toLowerCase());

        String q2="/services/myJava";
        String val2=removeEnd(q2, "Service");
        System.out.println("val2:"+val2);


        String q3="/services/myJavaService";
        String val3=removeEnd(q3, "Service");
        System.out.println("val:"+val3);
    }

}
