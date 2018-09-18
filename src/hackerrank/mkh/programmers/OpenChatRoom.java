package hackerrank.mkh.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	
	public static String[] solution(String[] record) {
		String[] answer = {};
		Map<String, String> map = new HashMap<>();
		
		for(int i=0; i<record.length; i++) {
			String[] temp = record[i].split(" ");
			
			if(!temp[0].equals("Leave")) {
				map.put(temp[1], temp[2]);	
			}
		}
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<record.length; i++) {
			String[] temp = record[i].split(" ");
			
			if(!temp[0].equals("Change")) {
				if(temp[0].equals("Enter")) {
					list.add(map.get(temp[1])+"님이 들어왔습니다.");	
				} else {
					list.add(map.get(temp[1])+"님이 나갔습니다.");
				}
			} 
		}
		
		answer = list.stream().toArray(String[]::new);
		return answer;
	}
}
