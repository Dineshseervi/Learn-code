package main.java.creational.singleton;

import java.io.*;

public class TestSingleton {

    public static void main(String[] args) {

        LazySingleton lazySingletonFirst=LazySingleton.getInstance();
        LazySingleton lazySingletonThirsd=LazySingleton.getInstance();
        System.out.println("objecy crated first "+lazySingletonFirst);
        System.out.println("does objects are equal : "+(lazySingletonFirst==lazySingletonThirsd));
        try {

            ObjectOutput objectOutput=new ObjectOutputStream(new FileOutputStream("lazySingleToneFile"));
            objectOutput.writeObject(lazySingletonFirst);
            objectOutput.close();

            ObjectInput objectInput=new ObjectInputStream(new FileInputStream("lazySingleToneFile"));
            LazySingleton lazySingletonSecond=(LazySingleton) objectInput.readObject();
            objectInput.close();

            System.out.println(lazySingletonSecond);
            ObjectInput objectInput2=new ObjectInputStream(new FileInputStream("lazySingleToneFile"));
            LazySingleton lazySingletonSecond2=(LazySingleton) objectInput2.readObject();
            objectInput2.close();

            System.out.println(lazySingletonSecond2);
            System.out.println("does objects are equal "+(lazySingletonSecond==lazySingletonSecond2));

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
