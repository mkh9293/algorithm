package hackerrank.mkh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            
            chkBalance(expression);
        }

        scanner.close();
	}
	
	static void chkBalance(String s) {
		Stack<String> stack = new Stack<>();
		String[] arr = s.split("");
		for(int i=0; i<arr.length; i++) {
			stack.push(arr[i]);
		}

		int i = stack.size() - 1;
		while(stack.size() > 0 && i >= 0) {
			String curS = stack.get(i);
			if(curS.equals("{") || curS.equals("(") || curS.equals("[")) {
				String matchS = matchString(curS);
				
				for(int j=i+1; j<stack.size(); j++) {
					if(matchS.equals(stack.get(j))) {
						stack.remove(i);
						stack.remove(i);
						break;
					} else {
						System.out.println("NO");
						return;
					}
				}
			} 
			i--;
		}
		
		if(stack.size() > 0 || i >= 0) System.out.println("NO"); 
		else System.out.println("YES"); 
	}
	
	static String matchString(String s) {
		String temp = "";
		switch(s) {
	        case "{" : temp = "}"; break;
	        case "(" : temp = ")"; break;
	        case "[" : temp = "]"; break;
		}	
	
		return temp;
	}
}
