package hackerrank.cheoljin_kang.codility.time_complexity;

/*
    Problem source : https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        final int[] A = {3, 1, 2, 4, 3};
        System.out.println("result : " + solution(A));
    }

    static int solution(int[] A) {
        int[] result = new int[A.length];
        int minValue = 100000;
        int allSum = 0;
        int leftSum;
        int rightSum;
        if (A.length >= 2) {
            for (int i = 0; i < A.length; i++) {
                allSum += A[i];
            }
            leftSum = A[0];
            rightSum = allSum - leftSum;
            for (int i = 1; i < A.length; i++) {
                result[i] = Math.abs(leftSum - rightSum);
                leftSum += A[i];
                rightSum -= A[i];
            }
            for(int i = 1; i<result.length; i++) {
                minValue = Math.min(minValue, result[i]);
            }
        }
        return minValue;
    }
}
