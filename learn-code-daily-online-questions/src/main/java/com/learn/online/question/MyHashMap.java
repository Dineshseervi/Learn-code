package com.learn.online.question;

import java.util.LinkedList;
import java.util.Objects;

class MyHashMap {

    /** Initialize your data structure here. */

    LinkedList<Event>[] map=null;
    int mapSize=500;
    public MyHashMap() {
        map=new LinkedList [mapSize];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket=key%mapSize;
        if(map[bucket]==null)
        {
            map[bucket]=new LinkedList<Event>();
            map[bucket].add(new Event(key,value));
        }else{
            for(Event event:map[bucket])
            {
                if(event.key==key){
                    event.value=value;
                    return;
                }
            }
            map[bucket].add(new Event(key,value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket=key%mapSize;
        if(map[bucket]==null)
        {
            return -1;
        }else{
            for(Event event:map[bucket])
            {
                if(event.key == key){
                    return event.value;
                }
            }
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket=key%mapSize;
        if(map[bucket]==null)
        {
            return ;
        }else{
            Event e=null;
            for(Event event:map[bucket])
            {
                if(event.key == key){
                    e=event;
                    break;
                }
            }
            if(e!=null)
            {
                map[bucket].remove(e);
            }

        }
    }
    class Event{
        Integer key;
        Integer value;
        public Event(Integer key,Integer value)
        {
            this.key=key;
            this.value=value;
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
