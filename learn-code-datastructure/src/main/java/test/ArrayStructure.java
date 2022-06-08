package main.java.test;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class ArrayStructure {

    public static void main(String[] args) {
        SystemPermission [] systemPermissions=SystemPermission.values();
        System.out.println(Arrays.toString(systemPermissions));

        List<String> list=new ArrayList<>();
        for(SystemPermission sp:SystemPermission.values())
        {
            list.add(sp.toString());
            //list.add("dinesh");
        }

        System.out.println(list);
        String a="dd";
        Set<String> set=new HashSet<>();
        char [] charA=a.toCharArray();
        List<Character> listB=new ArrayList<>();
        //listB.add(Arrays.asList(ArrayUtils));

    }
}

enum SystemPermission
{
    AUDIT_LOGGER,
    PERMISSION_2,
    PERMISSION_3,
    PERMISSION_4
}
