package hackerrank.mkh.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateMemo2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		List<Content> list = new ArrayList<>();
		while (true) {
			input = br.readLine();
 			if(input.equals("END")) break;
 			
 			Pattern p = Pattern.compile("\\d{2,4}[/년-]?\\d{1,2}[/월-]?\\d{1,2}[/일-]?");
 			Matcher m = p.matcher(input);
 			
 			while(m.find()) {
 				String[] dates = m.group(0).split("[/년월일-]");
 				Content cont = new Content(dates[0], dates[1], dates[2], input);
 				list.add(cont);
 			}
		}
		
		Collections.sort(list);
		list.forEach(x->System.out.println(x.memo));
	}
}

class Content implements Comparable<Content> {
	String memo;
	Date date;
	
	public Content(String year, String month, String day, String memo) throws ParseException {
		this.memo = memo;
		if(year.length()  < 4) year  = "20" + year;
		if(month.length() < 2) month = "0"  + month;
		if(day.length()   < 2) day   = "0"  + day;
		
		String temp = year + month + day;
		this.date = new SimpleDateFormat("yyyyMMdd").parse(temp);
	}
	
	@Override
	public int compareTo(Content cont) {
		if(this.date.compareTo(cont.date) > 0) {
			return 1;
		} else {
			return -1;
		}
	}
}
