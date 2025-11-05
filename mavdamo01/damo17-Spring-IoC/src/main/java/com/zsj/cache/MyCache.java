package com.zsj.cache;

import java.util.HashMap;
import java.util.Map;

public class MyCache {
    private static Map<String,String> cache;
    static {
        cache = new HashMap<>();
    }

    public static String get(String key){
        return cache.get(key);
    }
    public static void set(String key,String value){
        cache.put(key,value);
    }
}
