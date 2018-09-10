package hackerrank.mkh.programmers;

import java.util.Arrays;

public class SecretMap {
	public static void main(String[] args) {
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};
		newSolution(6,arr1, arr2);
	}
	
	static String[] newSolution(int n, int[] arr1, int[] arr2) {
		String[] result = new String[n];
		for(int i=0; i<n; i++) {
			result[i] = Integer.toBinaryString(arr1[i] | arr2[i]).replace('0', ' ').replace('1', '#');
			while(result[i].length() != n) result[i] = ' ' + result[i];
		}
		
		return result;
	}
	
//	static String[] solution(int n, int[] arr1, int[] arr2) {
//		String[][] map = new String[n][n];
//		
//		map = settingMap(n, map, arr1);
//		map = settingMap(n, map, arr2);
//
//		String[] answer = new String[n];
//		for(int i=0; i<n; i++) {
//			StringBuilder temp = new StringBuilder();
//			for(int j=0; j<n; j++) {
//				temp.append(map[i][j]);
//			}
//			answer[i] = temp.toString();
//		}
//		
//		System.out.println(Arrays.toString(answer));
//		return answer;
//	}
//	
//	static String[][] settingMap(int n, String[][] map, int[] arr) {
//		for(int i=0; i<n; i++) {
//			StringBuilder temp = new StringBuilder(Integer.toBinaryString(arr[i]));
//			while(temp.length() < n) {
//				temp.insert(0,0);
//			}
//			
//			for(int j=0; j<n; j++) {
//				char c = temp.charAt(j);
//				if(c == '1' || (map[i][j] != null && map[i][j].equals("#"))) {
//					map[i][j] = "#";	
//				} else {
//					map[i][j] = " ";
//				}
//			}
//		}
//		StringBuilder s= new StringBuilder("*");
//		
//		return map;
//	}
}
