package hackerrank.mkh.etc;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetGifImage {
	public static void main(String[] args) {
		String str = "unicom6.unicomp.net - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/ HTTP/1.0\" 200 3985\n"
				+ "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.html HTTP/1.0\" 304 3985\n"
				+ "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.gif HTTP/1.0\" 304 3985\n"
				+ "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/test.gif HTTP/1.0\" 200 3985\n"
				+ "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/.gif HTTP/1.0\" 200 3985\n"
				+ "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftof111-122f.gif HTTP/1.0\" 200 3985\n";
		solution(str);
	}
	
	public static void solution(String str) {
		Set<String> map = new HashSet<>();
		
		String[] arr = str.split("\n");
		for(int i=0; i<arr.length; i++) {
			String[] strArr = arr[i].substring(arr[i].indexOf("\""), arr[i].length()-1).split(" ");
			
			String response = strArr[3];
			if(response.equals("200")) {
				Matcher m = Pattern.compile("[a-z0-9-]+.gif").matcher(strArr[1]);
				while(m.find()) {
					map.add(m.group(0));
				}
			}
		}
		
		map.forEach(x->System.out.println(x));
	}
}
