package hackerrank.mkh.leetcode;

import java.math.BigInteger;

/**
 * 
 * @author mkh
 * https://leetcode.com/problems/add-two-numbers/
 * 
 */
public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node11 = new ListNode(4);
		ListNode node111 = new ListNode(3);
		node1.next = node11;
		node11.next = node111;

		ListNode node2 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node222 = new ListNode(4);
		node2.next = node22;
		node22.next = node222;

		ListNode node33 = addTwoNumbers(node1, node2);

		while(node33 != null) {
			System.out.println(node33.val);
			node33 = node33.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String val1 = intToString(l1);
		String val2 = intToString(l2);

		BigInteger valInt1 = new BigInteger(val1);
		BigInteger valInt2 = new BigInteger(val2);
		BigInteger val = valInt1.add(valInt2);

		String[] str = String.valueOf(val).split("");
		int len = str.length;	

		int temp = Integer.parseInt(str[--len]);
		ListNode result = new ListNode(temp);
		for(int i=len-1; i>=0; i--) {
			temp = Integer.parseInt(str[i]);
			result = insert(result, temp);
		}

		return result;
	}

	public static ListNode insert(ListNode node, int data) {
		ListNode temp = node;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new ListNode(data);
		return node;	
	}

	public static String intToString(ListNode l1) {
		StringBuilder result = new StringBuilder();

		while(l1 != null) {
			result.insert(0, l1.val);
			l1 = l1.next;
		}

		System.out.println("result : " + result);

		return result.toString();
	}
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}