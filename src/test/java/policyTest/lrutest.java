package policyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lld.Cache.cache.policies.LRUCacheEvictionPolicy;

public class lrutest {

	private LRUCacheEvictionPolicy<Integer> lruEvictionPolicy;

	@BeforeEach
	public void init() {
		this.lruEvictionPolicy = new LRUCacheEvictionPolicy<Integer>();
	}

	@Test
	public void testEvict() {
		lruEvictionPolicy.insert(1);
		lruEvictionPolicy.insert(2);
		lruEvictionPolicy.insert(3);
		lruEvictionPolicy.insert(4);
		lruEvictionPolicy.insert(5);
		
		assertEquals(lruEvictionPolicy.evict(),1);
		assertEquals(lruEvictionPolicy.evict(),2);
		assertEquals(lruEvictionPolicy.evict(),3);
		assertEquals(lruEvictionPolicy.evict(),4);
		assertEquals(lruEvictionPolicy.evict(),5);
		assertEquals(lruEvictionPolicy.evict(),null);
		assertEquals(lruEvictionPolicy.evict(),null);
	}

	@Test
	public void testUpdate() {
		lruEvictionPolicy.insert(1);
		lruEvictionPolicy.insert(2);
		lruEvictionPolicy.insert(3);
		lruEvictionPolicy.update(2);
		assertEquals(lruEvictionPolicy.getOldest(),1);
		assertEquals(lruEvictionPolicy.getRecent(),2);
		lruEvictionPolicy.insert(4);
		lruEvictionPolicy.insert(5);
		lruEvictionPolicy.insert(6);
		assertEquals(lruEvictionPolicy.getRecent(),6);
		lruEvictionPolicy.update(1);
		assertEquals(lruEvictionPolicy.getOldest(),3);
		assertEquals(lruEvictionPolicy.getRecent(),1);
	}

	@Test
	public void testInsert() {
           assertEquals(lruEvictionPolicy.insert(1).getKey(), 1);
           assertEquals(lruEvictionPolicy.insert(2).getKey(), 2);
           assertEquals(lruEvictionPolicy.insert(3).getKey(), 3);
	}
}
