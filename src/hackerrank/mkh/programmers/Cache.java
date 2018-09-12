package hackerrank.mkh.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	public static void main(String[] args) {
		String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//		String[] arr = {Jeju, Pangyo, Seoul, Jeju, Pangyo, "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(solution(3, arr));
	}
	
	static int solution(int cacheSize, String[] cities) {
		Queue<String> queue = new LinkedList<>();
		HashMap<String,Integer> map = new HashMap<>();
		
		int miss = 5;
		int hit = 1;
		int answer = 0;
		String city = "";
		
		for(int i=0; i<cities.length; i++) {
			
			city = cities[i].toLowerCase(); 
			if(queue.contains(city)) {
				queue.remove();
				queue.add(city);
//				map.put(city, (int)map.getOrDefault(city, 0)+1);
				answer += hit;
				
			} else {
				answer += miss;
//				map.put(city,0);
				queue.add(city);
				if(queue.size() > cacheSize) {
					queue.remove();
				}
			}
		}
		
		return answer;
	}
	
//	static String getLowHit(Queue<String> queue, HashMap<String, Integer> map) {
//		String item = queue.peek();
//		boolean result = false;
//		
//		for(String s : queue) {
//			if(map.get(s) < map.get(item)) {
//				item = s;
//				result = true;
//			}
//		}
//
//		return (result) ? item : queue.peek();
//	}
}
