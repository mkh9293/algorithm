package hackerrank.mkh;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FindRunningMedian {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		 int n = scanner.nextInt();
		 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		 int[] a = new int[n];

		 for (int i = 0; i < n; i++) {
			 int aItem = scanner.nextInt();
			 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			 a[i] = aItem;
		 }
		 
		 Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		 Queue<Integer> min = new PriorityQueue<>();
		 int value = 0;
		 double median = 0d;
		 
		 for(int i=0; i<a.length; i++) {
			 if(a[i] < median) {
				 max.add(a[i]);
			 } else {
				 min.add(a[i]);
			 }
			 
			 // 1. max 또는 min힙이 2개이상 개수가 차이나면 가장 먼저 들어온 값을 다른 힙으로 옮긴다.
			 if(min.size() > max.size() + 1) {
				 max.add(min.remove());
			 } else if (max.size() > min.size() + 1) {
				 min.add(max.remove());
			 }
			 
			 // 2. max와 min 힙의 사이즈가 같으면 두개를 더하여 출력
			 // 3. 사이즈가 다르다면, 더 큰 쪽의 힙의 값을 리턴.
			 if(max.size() == min.size()) {
				 median = (min.peek() + max.peek()) / 2.0;
			 } else if (max.size() > min.size()) {
				 median = max.peek();
			 } else {
				 median = min.peek();
			 }
			 
			 System.out.println(median);
		 }
	}
}
