package com.learn.online.question;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public interface ReadService<K,V> {

    V read(K k);
}

//cacheServiceImpl
//replace couchbase
//read from localcache if not found call underline value



/*
class CacheServiceImple<K,V> implements ReadService<K,V>
{
    //@autowise
    public ReadService readService;

    private Map<K,V>  cache=new ConcurrentHashMap<>();

    @Override
    public V read(K k) {
        //if(cache.read(k)==null)
        V v=cache.get(k);
        if(v==null)
        {
            return (V)readService.read(k);
        }else{
            return v;
        }
    }
}
*/

class WorkerAddData implements Runnable {

private List<Double> list;
//private Map<String,Double> map;

    public WorkerAddData(List<Double> list) {
        this.list = list;
        //this.map = map;
    }

    @Override
    public void run() {
        while (true)
        {
            list.add(Math.random());
            try {
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

class WorkerProcessData implements Runnable {

    private List<Double> list;
    private Map<String,Double> map;

    public WorkerProcessData(List<Double> list, Map<String, Double> map) {
        this.list = list;
        this.map = map;
    }

    @Override
    public void run() {
        while (true) {
            int i=0;
           Optional optional= list.stream().filter(a -> a % 2 == 0).max(Comparator.naturalOrder());
           if(optional.isPresent())
           {
               map.put("MAX_KEY",(Double) optional.get());
           }


            try {
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

class WorkerMaxValue implements Runnable {

    private Map<String,Double> map;

    public WorkerMaxValue( Map<String, Double> map) {
        this.map = map;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("MAX VALUE" + map.get("MAX_KEY"));
            //System.in
            try {
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}


class ProcessData{
    public static void main(String[] args) {
        List<Double> list=new CopyOnWriteArrayList<>();
        Map<String,Double> map=new ConcurrentHashMap<>();

        Runnable r1=new WorkerAddData(list);
        Runnable r2=new WorkerProcessData(list,map);
        Runnable r3 =new WorkerMaxValue(map);

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();

    }


}



