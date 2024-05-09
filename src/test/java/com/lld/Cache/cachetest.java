package com.lld.Cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lld.Cache.cache.Cache;
import com.lld.Cache.cache.enums.EvictionPolicy;
import com.lld.Cache.cache.exceptions.KeyNotFoundException;
import com.lld.Cache.cache.factories.HashMapBasedCacheFactory;

public class cachetest {

	private Cache<Integer, Integer> cache;

	@BeforeEach
	public void init() {
		this.cache = new HashMapBasedCacheFactory<Integer, Integer>().getCache(EvictionPolicy.LRU, 10);
	}

	@Test
	public void testCache() {

		Exception exception = assertThrows(KeyNotFoundException.class, () -> cache.get(1));
		System.out.println(exception.getMessage());
		try {
			cache.put(1, 2);
			assertEquals(cache.get(1),2);
			cache.put(1, 3);
			assertEquals(cache.get(1),3);
			cache.put(3, 4);
			cache.put(5, 6);
			assertEquals(cache.get(5),6);
		} catch (Exception e) {

		}
	}
}
