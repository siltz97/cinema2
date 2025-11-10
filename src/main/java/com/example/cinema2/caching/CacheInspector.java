package com.example.cinema2.caching;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CacheInspector {

    private final CacheManager cacheManager;

    public void printCacheContent(){
        Cache cache = cacheManager.getCache("users");
        if(cache == null){
            System.out.println("No cache found");
            return;
        }
        Object cacheNative = cache.getNativeCache();
        if(cacheNative != null && cacheNative instanceof com.github.benmanes.caffeine.cache.Cache<?,?> caffeine){
            System.out.println("contenuto cache: ");
            caffeine.asMap().forEach((k,v)->{
                System.out.println("key: "+k+" value: "+v);
            });
        }
    }
}
