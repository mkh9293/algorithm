package hackerrank.cheoljin_kang.codility.sorting;

import java.util.HashSet;
import java.util.Set;

/*
    Problem source : https://app.codility.com/programmers/lessons/6-sorting/distinct/
 */
public class Distinct {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int result;
        Set<Integer> mySet = new HashSet<>();
        for(int value : A) {
            mySet.add(value);
        }
        result = mySet.size();
        return result;
    }
}
