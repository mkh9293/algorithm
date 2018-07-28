package hackerrank.cheoljin_kang.array;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        List<Integer> result = move(a, 4);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    static List<Integer> move(int[] a, int d) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            result.add(a[i]);
        }
        for (int i = 0; i < d; i++) {
            int removeValue = result.remove(0);
            result.add(removeValue);
        }
        return result;
    }
}
