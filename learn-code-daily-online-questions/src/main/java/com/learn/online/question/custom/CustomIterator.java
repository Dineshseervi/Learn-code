package com.learn.online.question.custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomIterator<Type> implements Iterator<Type> {

    public Type [] array ;
    private int pointer =0;
    private int maxSize=0;
    private List<Type> iteratorlist;

    public CustomIterator(List<Type> list) {
        setArray(list);
    }

    private void setArray(List<Type> list)
    {
        if(list!=null)
        {
            array= (Type[]) new Object[list.size()];
            maxSize=list.size()-1;
            for (int i=0;i<list.size();i++)
            {
                array[i]=list.get(i);
            }
        }
        iteratorlist=list;
    }


    @Override
    public boolean hasNext() {
        return pointer <maxSize;
    }

    @Override
    public Type next() {
        return array[pointer++];
    }

    @Override
    public void remove() {
        iteratorlist.remove(pointer);
    }

    /*@Override
    public void forEachRemaining(Consumer<? super Type> action) {

    }*/
}

class Test{

    public static void main(String[] args) {
        System.out.println("test");
        List<String> list=new ArrayList<>();
        list.add("àaaaaa");
        list.add("bbbbbbb");
        list.add("cccc");
        list.add("ddddd");
       CustomIterator customIterator=new CustomIterator<String>(list);
       while (customIterator.hasNext())
       {
           System.out.println(""+customIterator.next());
       }
    }
}
