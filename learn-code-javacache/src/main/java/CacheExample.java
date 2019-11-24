package main.java;



import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheExample {

    public static Cache<String, String> tokenVsAccountDetailsMap = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.MINUTES).build();
    public static void main(String[] args) throws Exception {

        tokenVsAccountDetailsMap.put("dinesh","seervi");
        System.out.println("object 1 "+tokenVsAccountDetailsMap.getIfPresent("dinesh"));
        //Thread.sleep(300000);
        System.out.println("object 2 "+tokenVsAccountDetailsMap.getIfPresent("dinesh"));
    }
}
