package main.java.test;

public class TestChildPArent {
    public static void main(String[] args) {
        System.out.println(SubClass.A);
        SuperClass superClass=new SubClass();
        superClass.buzz();
        superClass.foo();
        superClass.bar();
        System.out.println("val:"+superClass.A);
    }

}
