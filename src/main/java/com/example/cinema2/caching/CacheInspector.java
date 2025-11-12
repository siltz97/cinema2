package com.example.cinema2.caching;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CacheInspector{

    private final CacheManager cacheManager;

    public void printCacheContent() {
        Cache cache = cacheManager.getCache("users");
        if (cache == null) {
            System.out.println("No cache found");
            return;
        }
        Object cacheNative = cache.getNativeCache();
        if (cacheNative != null && cacheNative instanceof com.github.benmanes.caffeine.cache.Cache<?, ?> caffeine) {
            System.out.println("contenuto cache: ");
            caffeine.asMap().forEach((k, v) -> {
                System.out.println("key: " + k + " value: " + v);
            });
        }
    }

    public void addCacheContent(Long key,Object value, String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        cache.put(key, value);
    }

    public void debugCache() {
        Cache cache = cacheManager.getCache("users");
        var nativeCache = cache.getNativeCache();

        if (nativeCache instanceof com.github.benmanes.caffeine.cache.Cache<?, ?> caffeine) {
            System.out.println("Cache attiva: " + caffeine);
            caffeine.asMap().forEach((key, value) ->
                    System.out.println(" → " + key.getClass().getSimpleName() + " : " + key + " => " + value)
            );
        }
    }
}
