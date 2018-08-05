package hackerrank.cheoljin_kang.linkedlist;

import java.util.HashMap;

/*
    Problem source : https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
*/
public class DetectCycle {
    boolean hasCycle(Node head) {
        Node currentNode = head;
        boolean result = false;
        HashMap<String, Integer> myMap = new HashMap<>();
        while(currentNode != null) {
            if(myMap.containsKey(String.valueOf(currentNode))) {
                result = true;
                break;
            }
            myMap.put(String.valueOf(currentNode), 1);
            currentNode = currentNode.next;
        }
        return result;
    }
    class Node {
        int data;
        Node next;
    }
}
