package hackerrank.cheoljin_kang.codility.time_complexity;

/*
    Problem source : https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5};
        System.out.println("result : " + solution(A));
    }

    static int solution(int[] A) {
        int result = 0;
        boolean[] array = new boolean[A.length+2];
        for(int i=0; i<A.length; i++) {
            array[A[i]] = true;
        }
        for(int i=1; i<array.length; i++) {
            if(array[i] == false) {
                result = i;
            }
        }
        return result;
    }
}
