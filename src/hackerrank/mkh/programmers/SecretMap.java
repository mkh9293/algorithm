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

		String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			StringBuilder temp = new StringBuilder();
			for(int j=0; j<n; j++) {
				temp.append(map[i][j]);
			}
			answer[i] = temp.toString();
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	static String[][] settingMap(int n, String[][] map, int[] arr) {
		for(int i=0; i<n; i++) {
			StringBuilder temp = new StringBuilder(Integer.toBinaryString(arr[i]));
			while(temp.length() < n) {
				temp.insert(0,0);
			}
			
			for(int j=0; j<n; j++) {
				char c = temp.charAt(j);
				if(c == '1' || (map[i][j] != null && map[i][j].equals("#"))) {
					map[i][j] = "#";	
				} else {
					map[i][j] = " ";
				}
			}
		}
		return map;
	}
}
