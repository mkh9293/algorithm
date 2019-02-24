package hackerrank.mkh.samsung;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Cryptogenerator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String num = scan.nextLine();
			if(num == null) break;
				
			String str = scan.nextLine();
			String[] arr = str.split(" ");
			int len = arr.length;
			
			Deque<Integer> queue = new ArrayDeque<>();
			int j = 1;
			
			for(int i=0; i<len; i++) {
				queue.add(Integer.parseInt(arr[i]));
			}
			
			int val = -1;
			while(true) {
				if(j == 6) j=1;
				if(val > 0) queue.addLast(val);
 				val = queue.pop() - (j++);
				
				if(val <= 0) {
					queue.addFirst(0);
					break;
				}	
//				queue.addLast(val);
			}
			
			System.out.println(queue);
		}
	}
}
