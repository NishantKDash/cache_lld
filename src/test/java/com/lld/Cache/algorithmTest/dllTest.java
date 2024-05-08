package com.lld.Cache.algorithmTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lld.Cache.cache.algo.DoublyLinkedList;
import com.lld.Cache.cache.algo.Node;

public class dllTest {
   
	@Test
	public void testAddNode()
	{
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
	
		
		dll.addNode(1);
		verifydll(dll, List.of(1));
		
		dll.addNode(2);
		verifydll(dll, List.of(1,2));
		
		dll.addNode(3);
		verifydll(dll, List.of(1,2,3));
		
		dll.addNode(4);
		verifydll(dll, List.of(1,2,3,4));
		
		dll.addNode(5);
		verifydll(dll, List.of(1,2,3,4,5));
		
		dll.addNode(6);
		verifydll(dll, List.of(1,2,3,4,5,6));
		
	}
	
	@Test
	public void testRemoveNode()
	{
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
	
		
		dll.addNode(1);
		dll.addNode(2);
		dll.addNode(3);
		dll.addNode(4);
		dll.addNode(5);
		dll.addNode(6);
		dll.addNode(7);
		
		dll.removeNode(dll.getHead().getNext());
		verifydll(dll, List.of(2,3,4,5,6,7));
		
		dll.removeNode(dll.getHead().getNext());
		verifydll(dll, List.of(3,4,5,6,7));
		
		dll.removeNode(dll.getHead().getNext());
		verifydll(dll, List.of(4,5,6,7));
		
		dll.removeNode(dll.getHead().getNext());
		verifydll(dll, List.of(5,6,7));
		
		dll.removeNode(dll.getHead().getNext());
		verifydll(dll, List.of(6,7));
		
		dll.removeNode(dll.getHead().getNext());
		verifydll(dll, List.of(7));
		
		dll.removeNode(dll.getHead().getNext());
		verifydll(dll, List.of());
		

	}
	
	@Test
	public void testUpdateNode()
	{
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
	
		
		dll.addNode(1);
		dll.addNode(2);
		dll.addNode(3);
		dll.addNode(4);
		dll.addNode(5);
		dll.addNode(6);
		dll.addNode(7);
		
		Node<Integer> n1 = dll.getHead().getNext();
		dll.updateNode(n1);
		verifydll(dll,List.of(2,3,4,5,6,7,1));
		
		Node<Integer> n2 = dll.getHead().getNext();
		dll.updateNode(n2);
		verifydll(dll,List.of(3,4,5,6,7,1,2));
		
		Node<Integer> n3 = dll.getHead().getNext();
		dll.updateNode(n3);
		verifydll(dll,List.of(4,5,6,7,1,2,3));
		
		Node<Integer> n4 = dll.getHead().getNext();
		dll.updateNode(n4);
		verifydll(dll,List.of(5,6,7,1,2,3,4));
		
		Node<Integer> n5 = dll.getHead().getNext();
		dll.updateNode(n5);
		verifydll(dll,List.of(6,7,1,2,3,4,5));
	}
	
	public void verifydll(DoublyLinkedList<Integer> dll, List<Integer> expected)
	{
        if(expected.size() == 0)
        {
        	assertEquals(dll.getHead().getNext(),null);
        	return;
        }
		assertEquals(dll.getTail().getKey(),expected.get(expected.size()-1));
		assertEquals(dll.getHead().getNext().getKey(),expected.get(0));
		
		Node<Integer> start = dll.getHead().getNext();
		for(Integer key : expected)
		{
			assertEquals(start.getKey(),key);
			start = start.getNext();
		}
	}
	
}
