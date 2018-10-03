package hackerrank.mkh.goorm;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class DateMemo {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		List<Memo> list = new ArrayList<Memo>();
		while (true) {
			input = br.readLine();
 			if(input.equals("END")) break;
 			
 			String[] arr = input.replaceAll("[^0-9]"," ").split(" ");
 			
 			int num = 0;
 			
 			for(String s : arr) {
 				if(s.equals("")) continue;
 				arr[num++] = s;
 			}
 			
 			String s = "";
 			for(int i=0; i<3; i++) {
 				if(i == 0 && arr[i].length() < 4) s = "20" + arr[i]; 
 				else s += String.format("%02d", Integer.parseInt(arr[i]));
 			}
 			
 			Date date = new SimpleDateFormat("yyyyMMdd").parse(s);
			list.add(new Memo(input,date));	
		}
		
		Collections.sort(list);
		list.forEach(x->System.out.println(x.memo));
	}
}

class Memo implements Comparable<Memo> {
	String memo;
	Date date;
	
	public Memo(String memo, Date date) {
		this.memo = memo;
		this.date = date;
	}
	
	@Override
	public int compareTo(Memo memo) {
		int num = this.date.compareTo(memo.date);
		if(num > 0) {
			return 1;
		} else {
			return -1;
		}
	}
}
