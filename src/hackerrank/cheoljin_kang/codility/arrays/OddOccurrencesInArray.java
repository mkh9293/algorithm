package hackerrank.cheoljin_kang.codility.arrays;

import java.util.*;

/*
    Problem source : https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        final int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        Map<Integer, Integer> myMap = new HashMap<>();
        Set<Integer> mySet = new HashSet<>();
        int result = -1;
        for (int i = 0; i < A.length; i++) {
            mySet.add(A[i]);
            if (!myMap.containsKey(A[i])) {
                myMap.put(A[i], 1);
            } else {
                myMap.put(A[i], myMap.get(A[i]) + 1);
            }
        }
        Iterator it = mySet.iterator();
        while (it.hasNext()) {
            int value = (Integer) it.next();
            if (myMap.get(value) % 2 == 1) {
                result = value;
            }
        }
        return result;
    }
}
