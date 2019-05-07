package hackerrank.mkh.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElevatorCapa {
	public static void main(String[] args) {
		int[] a = {60,80,40};
		int[] b = {2,3,5};
		int m = 5;
		int x = 2;
		int y = 200;
		System.out.println(solution(a, b, m, x, y));
	}
	
	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		int stopC  = 0;
		int count = 0;
		int peple = 0;
		while(count != A.length) {

			int max = 0;
			while(max <= Y && peple < A.length-1) {
				max += A[peple++];
				System.out.println(peple + " peple");
			}
			
			System.out.println(max);
//			for(int i=0; i<pepleC; i++) {
//				stopC++;
//			}
			
			count++;
		}
	
		return stopC;
	}
}
