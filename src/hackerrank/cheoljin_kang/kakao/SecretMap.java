package hackerrank.cheoljin_kang.kakao;

/*
    Problem source : https://programmers.co.kr/learn/courses/30/lessons/17681?language=java
 */
public class SecretMap {
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] result = solution(5, arr1, arr2);
        for (String value : result) {
            System.out.println(value);
        }
    }

    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int[] a = new int[n];
            int[] b = new int[n];
            String numberA = Integer.toBinaryString(arr1[i]);
            String numberB = Integer.toBinaryString(arr2[i]);
            int index = 0;
            for (int j = n - numberA.length(); j < n; j++) {
                a[j] = Integer.parseInt(String.valueOf(numberA.charAt(index)));
                index++;
            }
            index = 0;
            for (int j = n - numberB.length(); j < n; j++) {
                b[j] = Integer.parseInt(String.valueOf(numberB.charAt(index)));
                index++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (a[j] == 0 && b[j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            result[i] = sb.toString();
        }
        return result;
    }
}
