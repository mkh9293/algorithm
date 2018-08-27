package hackerrank.cheoljin_kang.codility.prefix_sums;

public class GenomicRangeQuery {
    static final int TYPE_SIZE = 4;

    public static void main(String[] args) {
        String s = "CAGCCTA";
        int[] p = {2, 5, 0};
        int[] q = {4, 5, 6};
        int[] result = solution(s, p, q);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    static int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();

        int[] impactCnt = new int[TYPE_SIZE];
        int[][] impactArray = new int[TYPE_SIZE][N + 1];

        for (int i = 0; i < N; i++) {
            int factor = letterToInt(S.charAt(i));
            impactCnt[factor - 1] += 1;

            for (int j = 0; j < TYPE_SIZE; j++) {
                impactArray[j][i + 1] = impactCnt[j];
            }
        }
        int M = P.length;
        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int start = P[i] + 1;
            int end = Q[i] + 1;
            for (int j = 0; j < TYPE_SIZE; j++) {
                if (impactArray[j][end] - impactArray[j][start - 1] > 0) {
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    static int letterToInt(char letter) {
        if (letter == 'A') return 1;
        if (letter == 'C') return 2;
        if (letter == 'G') return 3;
        if (letter == 'T') return 4;
        return -1;
    }
}
