package com.lld.Cache.cache.factories;

import com.lld.Cache.cache.Cache;
import com.lld.Cache.cache.enums.EvictionPolicy;
import com.lld.Cache.cache.policies.LRUCacheEvictionPolicy;
import com.lld.Cache.cache.storage.HashMapBasedStorage;

public class HashMapBasedCacheFactory<Key,Value> implements CacheAbstractFactory<Key,Value>{

	@Override
	public Cache<Key,Value> getCache(EvictionPolicy evictionPolicy, Integer capacity) {
		// TODO Auto-generated method stub
		if(evictionPolicy.equals(EvictionPolicy.LRU))
			return new Cache<Key,Value>(new LRUCacheEvictionPolicy<Key>(),new HashMapBasedStorage<Key,Value>(capacity));
		
		return null;
	}
 
}
