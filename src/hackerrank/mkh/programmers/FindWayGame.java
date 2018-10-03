package hackerrank.mkh.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWayGame {
	public static void main(String[] args) {
		int[][] nodeinfo = {
							{5,3},{11,5},{13,3},
							{3,5},{6,1},{1,3},
							{8,6},{7,2},{2,2}
							};
		
		solution(nodeinfo);
	}
	
	public static int[][] solution(int[][] nodeinfo){
		Map<Integer, int[]> map = new HashMap<>();
		for(int i=0; i<nodeinfo.length; i++) {
			map.put(i, nodeinfo[i]);
		}
		List<Integer> list = new ArrayList<>();
		
		list.addAll(map.keySet());
		
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				int[] v1 = map.get(o1);
				int[] v2 = map.get(o2);
				
				if(v1[1] > v2[1]) {
					return -1;
				} else if (v1[1] < v2[1]) {
					return 1;
				} else {
					if(v1[0] > v2[0]) return 1;
					else return -1;
				}
			}
		});
		
		int index = list.get(0);
		int x = 0;
		Node node = new Node(index+1, map.get(index)[0]);
		for(int i=1; i<list.size();i++) {
			index = list.get(i);
			x = map.get(index)[0];
			addNode(node, index, x);
		}
		
		List<Integer> preList = new ArrayList<>();
		List<Integer> postList = new ArrayList<>();
		
		preOrder(node, preList);
		postOrder(node, postList);
		
		int[][] answer = new int[2][nodeinfo.length];
		for(int i=0; i<preList.size(); i++) {
			answer[0][i] = preList.get(i);
		}
		for(int i=0; i<postList.size(); i++) {
			answer[1][i] = postList.get(i);
		}
		
		return answer;
	}
	
	public static Node addNode(Node node, int val, int x) {
		if(node == null) {
			Node tempNode = new Node(val+1, x);
			return tempNode;
		} else if (node.x > x) {
			node.left = addNode(node.left, val, x);
		} else {
			node.right = addNode(node.right, val, x);
		}
		return node;
	}
	
	public static void preOrder(Node node, List preList) {
		if(node != null) {
			preList.add(node.val);
			preOrder(node.left, preList);
			preOrder(node.right, preList);
		}
	}
	
	public static void postOrder(Node node, List postList) {
		if(node != null) {
			postOrder(node.left, postList);
			postOrder(node.right, postList);
			postList.add(node.val);
		}
	}
}

class Node{
	public int val;
	public int x;
	public Node left;
	public Node right;
	
	public Node(int val, int x) {
		this.val  = val;
		this.x    = x;
		this.left = null;
		this.right = null;
	}
}
