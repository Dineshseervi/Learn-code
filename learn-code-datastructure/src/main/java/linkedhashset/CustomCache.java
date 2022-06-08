package main.java.linkedhashset;

public interface CustomCache<K> {

    boolean get(K k);
    void put(K k);
}
