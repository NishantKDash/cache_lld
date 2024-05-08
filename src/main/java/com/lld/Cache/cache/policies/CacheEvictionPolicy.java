package com.lld.Cache.cache.policies;

import com.lld.Cache.cache.algo.Node;

public interface CacheEvictionPolicy<Key> {
    public Key evict();
    public void update(Key key);
    public Node<Key> insert(Key key);
}
