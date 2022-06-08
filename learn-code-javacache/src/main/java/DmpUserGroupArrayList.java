package main.java;

import java.util.ArrayList;
import java.util.Collection;

public class DmpUserGroupArrayList<T> extends ArrayList<String> {


    public DmpUserGroupArrayList(Collection<? extends String> c) {
        super(c);
    }

    @Override
    public boolean contains(Object o) {
        String paramStr = (String)o;
        for (String s : this) {
            if (paramStr.equalsIgnoreCase(s)) return true;
        }
        return false;
    }
}
