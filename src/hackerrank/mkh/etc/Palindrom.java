package hackerrank.mkh.etc;

public class Palindrom {
	public static void main(String[] args) {
//		String str = "oncn";
//		String str = "oncoder";
		String str = "aaaabaa";
//		String str = "xxxccxxc";
		
		System.out.println(solution(str));
	}
	
	public static int solution(String s) {
		if(s.length() < 2) return 1;
		
		String[] arr = s.split("");
		int j = arr.length - 1;
		int c = 0;

		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals(arr[j])) {
				j--;
			} else {
				c++;
			}
		}
		
		return c + s.length();
	}
}
