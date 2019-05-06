package hackerrank.mkh.etc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Calcurator {
	public static void main(String[] args) {
		String input = "3+[(5+1)-1]";
//		String input = "3+([5+1])";
//		String input = "3+{(5+1}";
//		String input = "3+[{(5+1)-1}+3]";
		
		Map<String, Integer> openerMap = new HashMap<>();
		openerMap.put("(", 1);
		openerMap.put("{", 2);
		openerMap.put("[", 3);
		
		Map<String, Integer> closerMap = new HashMap<>();
		closerMap.put(")", 1);
		closerMap.put("}", 2);
		closerMap.put("]", 3);
		
		String result = "true";
		String[] arr = input.split("");
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int i=0; i<arr.length; i++) {
			if(openerMap.containsKey(arr[i])) {
				if(!q.isEmpty() && q.peek() < openerMap.get(arr[i])) {
					result = "false";
					break;
				} else {
					q.push(openerMap.get(arr[i]));
				}
			}
			
			else if(closerMap.containsKey(arr[i])) {
				if(!q.pop().equals(closerMap.get(arr[i]))) {
					result = "false";
					break;
				}
			}	
		}
		
		System.out.println(result);
	}
}
