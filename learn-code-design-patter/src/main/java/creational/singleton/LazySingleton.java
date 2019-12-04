package main.java.creational.singleton;

import java.io.Serializable;

public class LazySingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private static volatile LazySingleton lazySingleton=null;

    private LazySingleton()
    {}

    public static LazySingleton getInstance()
    {
        if (lazySingleton==null)
        {
            synchronized (LazySingleton.class)
            {
                if(lazySingleton==null)  //double checking for threads
                {
                    lazySingleton=new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    protected Object readResolve() {   //this help in overcoming issue of deserialization
        return lazySingleton;
    }
}
