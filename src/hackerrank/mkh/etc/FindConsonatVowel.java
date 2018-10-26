package hackerrank.mkh.etc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindConsonatVowel {
	public static void main(String[] args) {
//		String[] text = {"toast", "standard", "bank", "display", "book"};
		String[] text = {"tooast","standard", "bank", "display", "book"};
		solution(text);
	}
	
	public static void solution(String[] text) {
		int count1 = 0;
		int count2 = 0;
		
		for(int i=0; i<text.length; i++) {
			String str = text[i].toLowerCase();
			
			Pattern p = Pattern.compile("[aeiou]{2,}");
			Matcher m = p.matcher(str);
			
			while(m.find()) {
				if(m.group().length() == 2) count1++;
			}
			
			
			p = Pattern.compile("[^aeiou]{3,}");
			m = p.matcher(str);
			while(m.find()) {
				if(m.group().length() == 3) count2++;
			}
			
		}
		System.out.println(count1);
		System.out.println(count2);
	}
}
