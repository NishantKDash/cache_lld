package com.lld.Cache.cache.algo;

public class DoublyLinkedList<Key> {
	private Node<Key> head;
	private Node<Key> tail;

	public Node<Key> getHead() {
		return head;
	}

	public void setHead(Node<Key> head) {
		this.head = head;
	}

	public Node<Key> getTail() {
		return tail;
	}

	public void setTail(Node<Key> tail) {
		this.tail = tail;
	}

	public DoublyLinkedList() {
		Node<Key> newNode = new Node<Key>(null, null, null);
		this.head = newNode;
		this.tail = newNode;

	}

	public Node<Key> addNode(Key key) {
		Node<Key> newNode = new Node<Key>(null, null, key);
		tail.setNext(newNode);
		newNode.setPrev(tail);
		tail = newNode;
		return newNode;
	}

	public void removeNode(Node<Key> node) {
		Node<Key> prev = node.getPrev();
		Node<Key> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
	}

	public void updateNode(Node<Key> node) {
		Node<Key> prev = node.getPrev();
		Node<Key> next = node.getNext();;
		node.setPrev(null);
		node.setNext(null);
		prev.setNext(next);
		next.setPrev(prev);
		tail.setNext(node);
		node.setPrev(tail);
		tail = node;
	}
}
