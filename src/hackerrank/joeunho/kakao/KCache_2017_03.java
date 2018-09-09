package hackerrank.joeunho.kakao;

import java.util.ArrayList;
import java.util.List;

public class KCache_2017_03 {
    public static void main(String[] args) {
       /* String[] cities={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int cacheSize=3;*/

        String[] cities={"Jeju", "Pangyo", "NewYork", "newyork"};
        int cacheSize=2;
        solution(cacheSize,cities);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){
            answer=5*cities.length;
        }else {
            List<String> list = new ArrayList<String>();

            for (int i = 0; i < cities.length; i++) {
                if("".equals(cities[i])){
                    cities[i] = "X";
                }else {
                    cities[i] = cities[i].toUpperCase();
                }
            }


            String temp = null;

            for (String s : cities) {
                if (!list.contains(s)) {//포함되어 있지않고
                    if (list.size() < cacheSize) {//캐시공간이 남았을 경우
                        list.add(s);
                        answer += 5;
                    } else {
                        list.remove(0);
                        list.add(list.size(), s);
                        answer += 5;
                    }

                } else {//포함이 되어 있고
                    int index = list.indexOf(s);
                    temp = list.get(index);
                    list.remove(s);
                    list.add(list.size(), temp);
                    answer += 1;
                }
                temp = null;
            }

            System.out.println("answer : " + answer);
        }

        return answer;
    }
}
