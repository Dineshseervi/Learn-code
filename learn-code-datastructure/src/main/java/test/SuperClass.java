package main.java.test;

public abstract class SuperClass {
    public static Integer A=200;

    static {
        System.out.println("super class static block");
    }

    public  void bar()
    {
        System.out.println("super class bar");
    }

    public static void foo()
    {
        System.out.println("super class foo");
    }

    public abstract void buzz();
}
