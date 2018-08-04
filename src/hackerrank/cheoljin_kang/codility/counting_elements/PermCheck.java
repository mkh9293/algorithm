package hackerrank.cheoljin_kang.codility.counting_elements;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 4};
        int[] A2 = {2, 3, 4, 5};
        int[] A3 = {1, 2, 4};

        System.out.println(solution(A1));
        System.out.println(solution(A2));
        System.out.println(solution(A3));
    }

    static int solution(int[] A) {
        Set<Integer> mySet = new HashSet<>();
        int minValue = A[0];
        int maxValue = 0;
        for (int i = 0; i < A.length; i++) {
            mySet.add(A[i]);
            if (A[i] < minValue) {
                minValue = A[i];
            }
            if (A[i] > maxValue) {
                maxValue = A[i];
            }
        }
        if (minValue == 1 && maxValue == A.length && mySet.size() == A.length) {
            return 1;
        }
        return 0;
    }
}
