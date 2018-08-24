package hackerrank.cheoljin_kang.codility.counting_elements;

public class MissingInteger {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 6, 4, 1, 2}; // 5
        int[] a2 = {1, 2, 3}; // 4
        int[] a3 = {-1, -3}; // 1
        int[] a4 = {1}; // 2
        System.out.println(solution(a1));
    }

    static int solution(int[] A) {
        int minValue = A[0];
        int maxValue = A[0];
        int result = -1;
        if (A.length == 1) {
            if (A[0] == 1) {
                result = 2;
            } else {
                result = 1;
            }
        } else {
            for (int i = 0; i < A.length; i++) {
                if (A[i] < minValue) {
                    minValue = A[i];
                }
                if (A[i] > maxValue) {
                    maxValue = A[i];
                }
            }
            if (minValue > 1 || maxValue < 1) {
                result = 1;
            } else {
                boolean[] array = new boolean[maxValue + 1];
                for (int i = 0; i < A.length; i++) {
                    array[A[i]] = true;
                }
                for (int i = 1; i < array.length; i++) {
                    if (array[i] == false) {
                        result = i;
                        break;
                    }
                }
                if (result == -1) {
                    result = maxValue + 1;
                }
            }
        }
        return result;
    }
}
