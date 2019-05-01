package hackerrank.mkh.etc;

import java.util.Arrays;

public class DecriptionText {
	public static void main(String[] args) {
		String text = "qyyigoptvfb";
		String key = "abcdefghijk";
		int rotation = 3;
		System.out.println(solution(text, key, rotation));
	}
	
	public static String solution(String text, String key, int rotate) {
		// 1. rotate
		String[] textArr = text.split("");
		int len = textArr.length;
		String[] result = new String[len];
		for(int i=0; i<len; i++) {
			if(rotate > 0) {
				result[(i+(len - rotate)) % len] = textArr[i];
				continue;
			} 
			
			result[(i+rotate) % len] = textArr[i];
		}
		
		StringBuilder str = new StringBuilder();
		for(int i=1; i<=len; i++) {
			int index = ('z' - result[i-1].charAt(0)) + i;

			if('z' - index < 'a') {
				index = 'a' - result[i-1].charAt(0) + i;
				str.append((char)('a' + index));
				continue;
			}
			str.append((char)('z' - index));
		}
		
		return str.toString();
	}
}

