package hackerrank.mkh.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	public static void main(String[] args) {
//		String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

		System.out.println(solution(2, arr));
	}
	
	static int solution(int cacheSize, String[] cities) {
		if(cacheSize == 0) return 5 * cities.length;
	      
	      int answer = 0;
	      int hit = 1;
	      int miss = 5;
	      String city;
	      
	      Queue<String> q = new LinkedList<>();
	      
	      for(int i=0; i<cities.length; i++) {
	          city = cities[i].toLowerCase();
	          if(q.contains(city)) {
	              answer += hit;
	              q.remove(city);
	              q.add(city);
	              
	          } else{
	              answer += miss;
	              q.add(city);    
	              if(cacheSize < q.size()) q.remove();
	          }
	      }
	      
	      return answer;
	}
}
