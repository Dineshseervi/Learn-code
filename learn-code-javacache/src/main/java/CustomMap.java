package main.java;

import sun.jvm.hotspot.oops.InstanceKlass;

import java.util.*;

public class CustomMap<E,K>  implements Map{

    private Map<E,K> map;
    private int addCount;

    public CustomMap(Map<E, K> map) {
        this.map = map;
    }


    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.map.containsValue(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override
    public K get(Object key) {
        return (K)this.map.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        addCount++;
        return this.map.put((E)key,(K)value);
    }

    @Override
    public Object remove(Object key) {
        addCount--;
        return this.map.remove(key);
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    public Integer getAddCount()
    {
        return addCount;
    }
}
