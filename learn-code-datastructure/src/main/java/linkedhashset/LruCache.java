package main.java.linkedhashset;


import java.util.LinkedHashSet;
import java.util.Set;

//Cache
public class LruCache implements CustomCache<Integer> {

    int capacity;
    Set<Integer> cache;

    public LruCache(int capacity) {
        this.cache=new LinkedHashSet<>(capacity);
        this.capacity = capacity;
    }


    @Override
    public boolean get(Integer val) {
        //O(1)
        if(cache.contains(val))
        {
            cache.remove(val);
            cache.add(val);
            return true;
        }
        return false;
    }

    private void refer(Integer val)
    {
        if(get(val)==false)
        {
            put(val);
        }
    }

    @Override
    public void put(Integer val) {
        if(cache.size()==capacity)
        {
           Integer first= cache.iterator().next();
           cache.remove(first);
        }
        cache.add(val);
    }
}
