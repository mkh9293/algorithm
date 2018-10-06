package hackerrank.mkh.etc;

import java.util.ArrayList;
import java.util.List;

public class BeautyYear {
	public static void main(String[] args) {
		int p = 1987;
		boolean check = false;
		
		
		
		while(!check) {
			List<Integer> list = new ArrayList<>();
			
			String str = String.valueOf(++p);
			char[] ch = str.toCharArray();
			for(int c : ch) {
				if(!list.contains(c)) {
					list.add(c);
					check = true;
				} else {
					check = false;
					break;
				}
			}
			
			if(check) break;
		}
		
		System.out.println(p);
	}
}
