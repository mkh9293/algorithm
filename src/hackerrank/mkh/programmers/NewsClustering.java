package hackerrank.mkh.programmers;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering {
	public static void main(String[] args) {
		solution("handshake", "shake hands");
	}
	
	public static int solution(String str1, String str2) {
		double answer = 0;
		
		String[] s1 = str1.toLowerCase().split("");
		String[] s2 = str2.toLowerCase().split("");
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		String temp = "";
		for(int i=0; i<s1.length; i++) {
			if(chkString(s1[i])) {
				temp += s1[i];
				
				if(temp.length() == 2) {
					list1.add(temp);
					temp = s1[i];
				}
			}
		}
		
		double intersec = 0; 
		temp = "";
		for(int i=0; i<s2.length; i++) {
			if(chkString(s2[i])) {
				temp += s2[i];
				
				if(temp.length() == 2) {
					if(list1.contains(temp)) {
						intersec++;
						list1.remove(temp);	
					} else {
						list2.add(temp);
					}
					temp = s2[i];
				} 
			}
		}
		
		answer = intersec/(intersec + list1.size() + list2.size());
		System.out.println((int)(answer * 65536));
		return (int)answer * 65536; 
	}
	
	
	public static boolean chkString(String s) {
		char c = s.charAt(0);
		if(c >='A' && c <= 'Z' || c >= 'a' && c <= 'z') {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	static void solution(String str1, String str2) {
//		String s1 = str1.toLowerCase();
//		String s2 = str2.toLowerCase();
//		
//		String[] arr1 = s1.split("");
//		String[] arr2 = s2.split("");
//		
//		HashSet<String> h1 = makeSet(arr1);
//		HashSet<String> h2 = makeSet(arr2);
//		
//		h1.forEach(x->System.out.println(x));
//	}
//	
//	static HashSet makeSet(String[] arr) {
//		HashSet<String> tempSet = new HashSet<>();
//		String s = "";
//		for(int i=0; i<arr.length; i++) {
//			if(chkString(arr[i])) {
//				s += arr[i];
//				
//				if(s.length() == 2) {
//					tempSet.add(s);
//					s = "";
//				}
//				
//			} else {
//				i++;
//			}
//		}
//		return tempSet;
//	}
//	

}
