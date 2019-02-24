package hackerrank.mkh.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class ObstacleRace {
	public static void main(String[] args) {
//		5
//		5
//		10 70 30 50 90
//		2
//		30 100
//		2
//		100 20
//		3
//		40 40 40
//		7
//		12 345 678 901 23 45 6

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for(int i=0; i<num; i++) {
			int n = scan.nextInt();
			
			scan.nextLine();
			String s = scan.nextLine();
			
			String[] sArr =  s.split(" ");
			
			int[] arr = new int[n]; 
			for(int j=0; j<sArr.length; j++) {
				arr[j] = Integer.parseInt(sArr[j]);
			}
			
			String answer = solution(arr);
			System.out.println("#" + (i+1) + " " + answer);
		}
	}
	
	public static String solution(int[] arr) {
		int max = 0;
		int min = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			int num = arr[i] - arr[i+1];
			int absVal = Math.abs(num);
			
			if(num < 0 && absVal > max) {
				// 올라가기
				max = absVal;
			} else if (num > 0 && absVal > min){
				// 내려가기
				min = absVal;
			}
		}
		
		return max+" "+min;
	}
}
