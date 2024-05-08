package com.lld.Cache.cache;

import com.lld.Cache.cache.exceptions.KeyNotFoundException;
import com.lld.Cache.cache.policies.CacheEvictionPolicy;
import com.lld.Cache.cache.storage.Storage;

public class Cache<Key,Value> {
   
	private Storage<Key,Value> storage;
	private CacheEvictionPolicy<Key> cacheEvictionPolicy;
	
	public Cache(CacheEvictionPolicy<Key> cacheEvictionPolicy, Storage<Key,Value> storage)
	{
		this.cacheEvictionPolicy = cacheEvictionPolicy;
		this.storage = storage;
	}
	
	public void put(Key key, Value value)
	{
		if(storage.containsKey(key))
		{
			storage.add(key, value);
			cacheEvictionPolicy.update(key);
			return;
		}
		if(storage.getCapacity() == storage.getCurrentSize())
		{
			Key deletedKey = cacheEvictionPolicy.evict();
			cacheEvictionPolicy.insert(key);
			storage.add(key, value);
			storage.remove(deletedKey);
			return;
		}
		storage.add(key, value);
		cacheEvictionPolicy.insert(key);
	}
	
	public Value get(Key key) throws KeyNotFoundException
	{
		if(!storage.containsKey(key))
		throw new KeyNotFoundException("The provided key does not exist");
		Value value = storage.get(key);
		cacheEvictionPolicy.update(key);
		return value;
	}
	

}
