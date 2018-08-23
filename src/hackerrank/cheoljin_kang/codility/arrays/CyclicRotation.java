package hackerrank.cheoljin_kang.codility.arrays;

import java.util.ArrayList;
import java.util.List;

/*
    Problem source : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class CyclicRotation {
    public static void main(String[] args) {
        int[] A = {0,0};
        int k = 0;
        int[] result = solution(A, k);
        for(int value : result) {
            System.out.print(value + " ");
        }
    }
    static int[] solution(int[] A, int K) {
        int[] result;
        if(K == 0) {
            result = A;
        } else {
            if(A.length == 0) {
                result = new int[0];
            } else {
                result = new int[A.length];
                final int moveCount = K % A.length;
                List<Integer> list = new ArrayList<>();

                for(int value : A) {
                    list.add(value);
                }
                for(int i = 0; i<moveCount; i++) {
                    int removeValue = list.remove(A.length-1);
                    list.add(0, removeValue);
                }
                for(int i=0; i<A.length; i++) {
                    result[i] = list.get(i);
                }
            }
        }
        return result;
    }
}
