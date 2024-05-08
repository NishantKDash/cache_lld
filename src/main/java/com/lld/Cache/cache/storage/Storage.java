package com.lld.Cache.cache.storage;

public interface Storage<Key,Value>{
  public void add(Key key, Value value);
  public void remove(Key key);
  public Value get(Key key);
  public boolean containsKey(Key key);
  public Integer getCapacity();
  public Integer getCurrentSize();
}
