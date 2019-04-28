package hackerrank.mkh.etc;

public class MQueue {
	public static void main(String[] args) {
		String[] input = {"a","b","c","d","e","f","g","h"};
		StringBuffer sb = new StringBuffer();
		int num = 1;
		
		for(int i=0; i<input.length; i++) {
			sb.append("[arr"+(num++)+","+input[i]+"]");
			
			if(num == 4) num = 1;
		}
		
		System.out.println(sb);
	}
}
