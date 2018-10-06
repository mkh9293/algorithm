package hackerrank.mkh.etc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OddSum {
	public static void main(String[] args) {
		String str = "ab2v9bc13j5jf4jv";
		int sum = 0;
		
		// 기본 풀이
		String[] arr = str.split("[^0-9]");
		for(String s : arr) {
			if(s.equals("")) continue;
			int num = Integer.parseInt(s);
			if(num % 2 != 0) sum += Math.pow(num, 2); 
		}
		System.out.println(sum);
		
		
		
		// 스트림 풀이
		sum = Arrays.asList(str.split("[^0-9]")).
				stream().
				filter(s->!s.equals("") && Integer.parseInt(s)%2!=0).
				mapToInt(i -> (int)Math.pow(Integer.parseInt(i),2)).
				sum();
		
		System.out.println(sum);
	}
}
