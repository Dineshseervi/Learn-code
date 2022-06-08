package main.java;

public class Learnbasic {

    private int age =6;
    private String name;
    static  boolean flag =true;  //initialization
    private Address address;

    {
        System.out.println("static block 1");
    }

    {
        System.out.println("static block 2");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Learnbasic.flag = flag;
    }



    public static void main(String[] args) {

        Learnbasic learnbasic=new Learnbasic();
        setFlag(true);
    }

    public Integer sum(Integer a,Integer b)
    {
        return  a+b;
    }
}
