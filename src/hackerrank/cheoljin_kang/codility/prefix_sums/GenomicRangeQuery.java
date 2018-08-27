package hackerrank.cheoljin_kang.codility.prefix_sums;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        String s = "CAGCCTA";
        int[] p = {2, 5, 0};
        int[] q = {4, 5, 6};
        int[] result = solution(s, p, q);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    static int[] solution(String S, int[] P, int[] Q) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("A", 1);
        myMap.put("C", 2);
        myMap.put("G", 3);
        myMap.put("T", 4);
        int[] result = new int[P.length];
        for (int i = 0; i < result.length; i++) {
            String slice = S.substring(P[i], Q[i] + 1);
            String[] s = slice.split("");
            int minValue = myMap.get(s[0]);
            for (int j = 1; j < s.length; j++) {
                if (myMap.get(s[j]) < minValue) {
                    minValue = myMap.get(s[j]);
                }
            }
            result[i] = minValue;
        }
        return result;
    }
}
