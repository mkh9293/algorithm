package hackerrank.mkh;

import java.util.ArrayList;
import java.util.List;

public class StringManipulation {
	public static void main(String[] args) {
		String s = "crswo";
		String t = "crows";
		
		System.out.println(solution(s,t));
	}
	
	static String solution(String S, String T) {
		String result = "IMPOSSIBLE";
		
		if(S==T) {
			result =  "NOTHING";
		} else if(S.length() != T.length()){
			// 문자의 길이가 다른 경우는 insert || remove
			if(S.length() > T.length()) {
				result = manipul(S,T, "remove");
			} else {
				result = manipul(S,T, "insert");
			}
		} else {
			
			// 문자의 길이가 같은 경우는 swap
			result = manipul(S,T, "swap");
		}
		
		return result;
	}
	
	static String manipul(String S, String T, String type) {
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		int size = s.length;
		int tSize = t.length;
		
		String temp = "IMPOSIBLE";
		
		if(type == "insert") {
			int count = 0;
			
			for(int i=0; i<size; i++) {
				if(count > 0) break;
				// 마지막 요소
				if(i+1 == tSize-1) temp = "INSERT "+t[i+1];
				
				if(s[i] == t[i]) {
					continue;
				} else {
					count++;
					temp = "INSERT "+t[i]; 
				}
			}
		} else if (type == "remove") {
			int count = 0;

			for(int i=0; i<tSize; i++) {
				if(count > 0) break;
				// 마지막 요소
				if(i+1 == size-1) temp = "REMOVE "+s[i+1];
				
				if(s[i] != t[i]) {
					temp = "REMOVE "+s[i];
					count++;
				} else {
					continue;
				}
			
			}
		} else {
			int count = 0;
			int idx = -1;
			
			for(int i=0; i<size; i++) {
				if(idx < 0 && s[i] != t[i]) {
					idx = i;
				} else if(s[i] != t[i]) {
					
					// 배열 바뀐 요소의 순서가 맞는지 체크
					if(s[idx] == t[i] && s[i] == t[idx]) {
						temp = "SWAP "+s[idx]+" "+s[i];
					}
				}
			}
		}
		
		return temp;
	}
}
