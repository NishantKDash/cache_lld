package com.lld.Cache.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
	private Map<Key, Value> storage;
	private final Integer capacity;

	public HashMapBasedStorage(Integer capacity) {
		this.capacity = capacity;
		this.storage = new HashMap<>();
	}

	@Override
	public void add(Key key, Value value) {
		storage.put(key, value);
	}

	@Override
	public void remove(Key key) {
		storage.remove(key);

	}


	public Integer getCapacity() {
		return capacity;
	}

	@Override
	public Value get(Key key) {
		return storage.get(key);
	}

	@Override
	public boolean containsKey(Key key) {
		return storage.containsKey(key);
	}

	@Override
	public Integer getCurrentSize() {
	   return storage.size();
	}

}
