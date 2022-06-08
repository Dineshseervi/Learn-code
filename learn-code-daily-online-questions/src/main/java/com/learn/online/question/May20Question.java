package com.learn.online.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class May20Question {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("D");
        list.add("E");
       Iterator<String> iterator= list.iterator();
       CustomIterator customIterator=new CustomIterator(iterator);
       while (customIterator.hasNext())
       {
           System.out.println(customIterator.next());
       }

    }
}

class CustomIterator<E> implements Iterator<E>
{
    Iterator<E> iterator;
    public CustomIterator(Iterator iterator) {
        this.iterator=iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        E firstVal= (E) iterator.next();//skip
        if(iterator.hasNext())
        {
            return iterator.next();
        }
        return firstVal;

    }
}
