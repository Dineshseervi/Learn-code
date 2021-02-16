package main.java.online.assisment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
public class StdinExample {
    public static void main(String[] args) {
       /* Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        Double d = scan.nextDouble();
        System.out.println("show:"+scan.nextLine());
        String s = scan.nextLine();

        System.out.println("String:" + s);
        System.out.println("Double:"  + d);
        System.out.println("Int: " + i);*/
        HashMap<String,String> map=new HashMap<String,String>();
        double val= 13/3.0d;
        System.out.println(val);

        Integer[][] myArr= {

                {5, 10},
                {0, 20},
                {25, 40},
                {35, 45} };

        /*java.util.Arrays.sort(array, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });*/

        Arrays.sort(myArr, (a, b) -> a[0] - b[0]);
        System.out.println("array"+Arrays.toString(myArr));

        //String s="";
        for (int i = 0; i<myArr.length; i++){
            String s= ""+myArr[i][1];
            /*for (int j = 0; j<myArr[i].length; j++){
                s += myArr[i][j];
            }*/ System.out.println(s);

        }

    }
}
