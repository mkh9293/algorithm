package hackerrank.mkh.programmers;

import java.util.Arrays;

public class AddSeconds {
	public static void main(String[] args) {
//		String time = "PM 01:00:00";
//		String time = "PM 11:59:59";
//		String time = "AM 12:10:00";
		String time = "AM 12:59:00";
		
//		System.out.println(130%60);
		System.out.println(solution(time, 86400));
	}
	
	public static String solution(String time, int str) {
		String result = "";
		String not = time.substring(0,3).trim();
		String[] times = time.replaceAll("[^0-9:]","").split(":");
		
		
		int seconds = Integer.parseInt(times[2])+str;
		int miniutes = Integer.parseInt(times[1]);
		int hour = Integer.parseInt(times[0]);

		if(seconds >= 60) {
			miniutes += (int) (seconds/60);
			
			seconds = seconds % 60;
		}
		
		if(miniutes >= 60) {
			hour += (int) (miniutes/60);
			
			miniutes = miniutes % 60;
		}
		
		String s = String.format("%02d", seconds);
		String m = String.format("%02d", miniutes);
		String h = String.format("%02d", hour);
		
		if(not.equals("PM") && hour < 12) {
			
			hour += 12;
			h = String.format("%02d", hour);
			
		} else if (not.equals("PM") && hour >= 12) {
			
			hour = (hour / 12) - 1;
			h = String.format("%02d", hour);
			
		} else if(not.equals("AM") && hour == 12) {
			h = "00";
			
		} else if(not.equals("AM") && hour >= 12) {
			hour = hour % 12;
			h = String.format("%02d", hour);
			
		}
		
		result = h+":"+m+":"+s;
		return result;
	}
}
