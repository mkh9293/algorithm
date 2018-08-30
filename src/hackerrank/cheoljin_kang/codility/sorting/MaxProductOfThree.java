package hackerrank.cheoljin_kang.codility.sorting;

import java.util.Arrays;

/*
    Problem source : https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        } else {
            int result;
            Arrays.sort(A);
            int startIndex = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= 0) {
                    startIndex = i;
                }
            }
            if (startIndex == -1) {
                result = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
            } else {
                int max1 = A[0] * A[1] * A[A.length - 1];
                int max2 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
                result = Math.max(max1, max2);
            }
            return result;
        }
    }
}
