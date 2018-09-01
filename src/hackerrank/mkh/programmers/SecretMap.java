package hackerrank.mkh.programmers;

import java.util.Arrays;

public class SecretMap {
	public static void main(String[] args) {
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		solution(5,arr1, arr2);
	}
	
	static String[] solution(int n, int[] arr1, int[] arr2) {
		String[][] map = new String[n][n];
		
		map = settingMap(n, map, arr1);
		map = settingMap(n, map, arr2);
		
		
//		for(int i=0; i<n; i++) {
//			String temp = Integer.toBinaryString(arr1[i]);
//			while(temp.length() < n) {
//				temp = 0 + temp;
//			}
//			
//			for(int j=0; j<n; j++) {
//				char c = temp.charAt(j);
//				if(c == '0') {
//					map[i][j] = " ";	
//				} else {
//					map[i][j] = "#";
//				}
//			}
//		}
//		
//		for(int i=0; i<n; i++) {
//			String temp = Integer.toBinaryString(arr2[i]);
//			while(temp.length() < n) {
//				temp = 0 + temp;
//			}
//			
//			for(int j=0; j<n; j++) {
//				char c = temp.charAt(j);
//				if(c == '0' && !map[i][j].equals("#")) {
//					map[i][j] = " ";	
//				} else {
//					map[i][j] = "#";
//				}
//			}
//		}
		String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			String temp = "";
			for(int j=0; j<n; j++) {
				temp += map[i][j];
			}
			answer[i] = temp;
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	static String[][] settingMap(int n, String[][] map, int[] arr) {
		for(int i=0; i<n; i++) {
			String temp = Integer.toBinaryString(arr[i]);
			while(temp.length() < n) {
				temp = 0 + temp;
			}
			
			for(int j=0; j<n; j++) {
				char c = temp.charAt(j);
				if(c == '#' && map[i][j].isEmpty()) {
					map[i][j] = "#";	
				} else {
					map[i][j] = " ";
				}
			}
		}
		return map;
	}
}
