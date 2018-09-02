package hackerrank.mkh.programmers;

import java.util.Hashtable;

public class DartGame {
	public static void main(String[] args) {
		String result = "1D2S3T*";
		solution(result);
	}
	
	static int solution(String result) {
		int answer = 0;
		Hashtable<String, Integer> table = new Hashtable<>();
		table.put("S",1);
		table.put("D",2);
		table.put("T",3);
		
		int[] temp = new int[3];
		int num = 0;
		int count = 0;
		
		for(int i=0; i<result.length(); i++) {
			String key = result.charAt(i) + "";
			
			if(table.containsKey(key)) {
				num = (int)Math.pow(num, table.get(key));
				temp[count++] = num;
				num = 0;
			} else if(key.equals("*")) {
				if(count-2 >= 0) temp[count-2] *= 2; 
				temp[count-1] *= 2;
			} else if(key.equals("#")) {
				temp[count-1] *= -1;
			} else {
				if(num > 0) key = "10";
				num = Integer.parseInt(key);
			}
		}
		
		for(int i=0; i<temp.length; i++) {
			answer += temp[i];
		}
		
		return answer;
	}
	
}
