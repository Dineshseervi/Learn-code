package com.learn.online.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class MyHashMapUpdated {

    /** Initialize your data structure here. */

    List<Event>[] map=null;
    int mapSize=500;
    public MyHashMapUpdated() {
        map=new ArrayList [mapSize];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket=key%mapSize;
        if(map[bucket]==null)
        {
            map[bucket]=new ArrayList<Event>();
            map[bucket].add(new Event(key,value));
        }else{
           int index= map[bucket].indexOf(new Event(key,null));
            if(index>-1)
            {
                map[bucket].get(index).value=value;
            }else {
                map[bucket].add(new Event(key, value));
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket=key%mapSize;
        if(map[bucket]==null)
        {
            return -1;
        }else{
            /*for(Event event:map[bucket])
            {
                if(event.key == key){
                    return event.value;
                }
            }*/
            int index=map[bucket].indexOf(new Event(key,null));
            if(index>-1)
            {
                return map[bucket].get(index).value;
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
            /*Event e=null;
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
            }*/

            int index=map[bucket].indexOf(new Event(key,null));
            if(index>-1)
            {
                map[bucket].remove(index);
            }
        }
    }
    class Event{
        private Integer key;
        private Integer value;
        public Event(Integer key,Integer value)
        {
            this.key=key;
            this.value=value;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Event event = (Event) o;
            return Objects.equals(key, event.key);
        }


        /*public int hashCode() {
            return Objects.hash(key);
        }*/
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
