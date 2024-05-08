package com.lld.Cache.cache.algo;

public class Node<Key> {


private Node<Key> next;
  private Node<Key> prev;
  private Key key;
  
  public Node(Key key)
  {
	  this.next = null;
	  this.prev = null;
	  this.key = key;
  }
  
  public Node<Key> getNext() {
		return next;
	}

	public void setNext(Node<Key> next) {
		this.next = next;
	}

	public Node<Key> getPrev() {
		return prev;
	}

	public void setPrev(Node<Key> prev) {
		this.prev = prev;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

 
}
