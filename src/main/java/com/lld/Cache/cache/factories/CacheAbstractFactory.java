package com.lld.Cache.cache.factories;

import com.lld.Cache.cache.Cache;
import com.lld.Cache.cache.enums.EvictionPolicy;

public interface CacheAbstractFactory<Key,Value> {
    public Cache<Key,Value>getCache(EvictionPolicy evictionPolicy, Integer capacity);
}
