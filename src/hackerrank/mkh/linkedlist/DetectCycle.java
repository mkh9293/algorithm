package hackerrank.mkh.linkedlist;

import java.util.ArrayList;

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/	
public class DetectCycle {
	class Node {
	   int data;
	   Node next;
	}

	static boolean hasCycle(Node head) {
		if(head == null) return false;
		Node nextNode = head.next.next;
		while(nextNode != null) {
			if(head == nextNode) return true;
			nextNode = nextNode.next.next;
			head = head.next;
		}
		
		return false;
	}
	
	static boolean _hasCycle(Node head) {
	    ArrayList<String> list = new ArrayList<>();
	    Node curNode = head;
	    while(curNode != null) {
	        if(list.contains(String.valueOf(curNode))) {
	            return true;
	        }
	        list.add(String.valueOf(curNode));
	        curNode = curNode.next;
	    }
	       return false;
	}
	
}



