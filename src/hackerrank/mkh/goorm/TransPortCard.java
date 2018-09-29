package hackerrank.mkh.goorm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TransPortCard {
	public static void main(String[] args) {
		String input = new Scanner(System.in).nextLine().trim();
		final StringTokenizer tokenizer = new StringTokenizer(input);
		
		int money = 20000;
		while (tokenizer.hasMoreTokens()) {
			int distance = Integer.parseInt(tokenizer.nextToken());
			
			// @todo Write your code here.
			if(distance <= 4 || distance >= 178) {
				break;
			}
			
			if(distance > 40) {
				double overDis = (double)(distance - 40) / 8;
				
				if(overDis == 0) overDis = 1;
				money -= 720 + (Math.ceil(overDis) * 80);
			} else {
				money -= 720;	
			}
		
			// 더이상 차감 불가
			if(money <= 0) {
				break;
			}
			
		}
		System.out.println(money);
	}
}
