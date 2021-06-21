package main.java.test;

public class SubClass extends SuperClass{
    public static Integer A=100;

    static {
        System.out.println("subClass static block");
    }

    public static void foo()
    {
        System.out.println("SubClass foo");
    }

    public  void bar()
    {
        System.out.println("SubClass bar");
    }

    @Override
    public void buzz() {
        System.out.println(A);
    }
}
