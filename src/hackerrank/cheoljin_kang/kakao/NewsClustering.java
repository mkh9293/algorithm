package hackerrank.cheoljin_kang.kakao;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Problem source : https://programmers.co.kr/learn/courses/30/lessons/17677?language=java
 */
public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(solution(str1, str2));
    }

    static int solution(String str1, String str2) {
        Map<String, Integer> myMap1 = new HashMap<>();
        Map<String, Integer> myMap2 = new HashMap<>();
        Set<String> union = new HashSet<>();
        Set<String> intersection = new HashSet<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            if (isAlphabet(str1.substring(i, i + 1)) && isAlphabet(str1.substring(i + 1, i + 2))) {
                String word = str1.substring(i, i + 2).toUpperCase();
                union.add(word);
                if (!myMap1.containsKey(word)) {
                    myMap1.put(word, 1);
                } else {
                    myMap1.put(word, myMap1.get(word) + 1);
                }
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (isAlphabet(str2.substring(i, i + 1)) && isAlphabet(str2.substring(i + 1, i + 2))) {
                String word = str2.substring(i, i + 2).toUpperCase();
                union.add(word);
                if (myMap1.containsKey(word)) {
                    intersection.add(word);
                }
                if (!myMap2.containsKey(word)) {
                    myMap2.put(word, 1);
                } else {
                    myMap2.put(word, myMap2.get(word) + 1);
                }
            }
        }
        if (myMap1.size() == 0 && myMap2.size() == 0) {
            return 65536;
        }
        double union_size = 0.0;
        double intersection_size = 0.0;
        for (String value : union) {
            if (myMap1.containsKey(value) && myMap2.containsKey(value)) {
                union_size += Math.max(myMap1.get(value), myMap2.get(value));
            } else {
                if (myMap1.containsKey(value)) {
                    union_size += myMap1.get(value);
                } else {
                    union_size += myMap2.get(value);
                }
            }
        }
        for (String value : intersection) {
            intersection_size += Math.min(myMap1.get(value), myMap2.get(value));
        }
        double j = intersection_size / union_size;
        return (int) (j * 65536);
    }

    static boolean isAlphabet(String str) {
        return str.matches("^[A-Za-z]]*$");
    }
}
