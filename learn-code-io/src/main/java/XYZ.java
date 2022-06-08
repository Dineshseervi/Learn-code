package main.java;

import java.util.Enumeration;
import java.util.Properties;

public class XYZ {
    public final void getData()
    {
        System.out.println("parent syz");
    }
}
class ChildXyz extends XYZ
{
    /**
     * Can't over ride final method in child
      * @param args
     */
    /*void getData()
    {
        System.out.println("child syz");
    }*/

    public static void main(String[] args) {

        System.setProperty("dinesh","march-15");
        String stringProperty= "";
        Properties p = System.getProperties();
        Enumeration keys = p.keys();

        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = (String)p.get(key);
            stringProperty = stringProperty + "" +(key + ": " + value);
        }
    }
}