package hackerrank.cheoljin_kang.codility.sorting;

import java.util.Arrays;

/*
    Problem source : https://app.codility.com/programmers/lessons/6-sorting/triangle/
 */
public class Triangle {
    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int result = 0;
        if (A.length < 3) {
            return result;
        } else {
            Arrays.sort(A);
            for (int i = 2; i < A.length; i++) {
                long longSide = (long) A[i];
                long plusSide = (long) A[i - 1] + (long) A[i - 2];
                if (longSide < plusSide) {
                    result = 1;
                    break;
                }
            }
            return result;
        }
    }
}
