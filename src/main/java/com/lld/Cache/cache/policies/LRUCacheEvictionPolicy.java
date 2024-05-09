package com.lld.Cache.cache.policies;

import java.util.HashMap;
import java.util.Map;

import com.lld.Cache.cache.algo.DoublyLinkedList;
import com.lld.Cache.cache.algo.Node;

public class LRUCacheEvictionPolicy<Key> implements CacheEvictionPolicy<Key> {

	private DoublyLinkedList<Key> dll;
	private Map<Key, Node<Key>> map;

	public LRUCacheEvictionPolicy() {
		this.dll = new DoublyLinkedList<>();
		this.map = new HashMap<>();
	}

	public Key evict() {
		Node<Key> head = dll.getHead();
		if (head.getNext() != null) {
			Node<Key> toBeDeleted = head.getNext();
			dll.removeNode(toBeDeleted);
			map.remove(toBeDeleted.getKey());
			return toBeDeleted.getKey();
		}
		return null;
	}

	@Override
	public void update(Key key) {
		Node<Key> node = map.get(key);
		dll.updateNode(node);
	}

	@Override
	public Node<Key> insert(Key key) {
		// TODO Auto-generated method stub
		Node<Key> newNode = dll.addNode(key);
		map.put(newNode.getKey(), newNode);
		return newNode;
	}

	public Key getRecent() {
		if (dll.getHead().getNext() == null)
			return null;
		return dll.getTail().getKey();
	}

	public Key getOldest() {
		if (dll.getHead().getNext() == null)
			return null;
		return dll.getHead().getNext().getKey();
	}

}
