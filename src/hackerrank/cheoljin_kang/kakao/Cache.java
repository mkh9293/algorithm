package hackerrank.cheoljin_kang.kakao;

import java.util.ArrayList;
import java.util.List;

/*
    Problem source : https://programmers.co.kr/learn/courses/30/lessons/17680?language=java
 */
public class Cache {
    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        final int MAX_CACHE_SIZE = 3;
        System.out.println(solution(MAX_CACHE_SIZE, cities));
    }

    static int solution(int MAX_CACHE_SIZE, String[] cities) {
        int answer = 0;
        final int HIT = 1;
        final int MISS = 5;
        List<String> myList = new ArrayList<>();
        if (MAX_CACHE_SIZE == 0) {
            return cities.length * MISS;
        }
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if (!myList.isEmpty()) {
                boolean hit = false;
                for (int j = 0; j < myList.size(); j++) {
                    if (myList.get(j).equals(city)) {
                        hit = true;
                        myList.remove(j);
                        break;
                    }
                }
                myList.add(city);
                if (hit) {
                    answer += HIT;
                } else {
                    if (myList.size() > MAX_CACHE_SIZE) {
                        myList.remove(0);
                    }
                    answer += MISS;
                }
            } else {
                myList.add(city);
                answer += MISS;
            }
        }
        return answer;
    }
}
