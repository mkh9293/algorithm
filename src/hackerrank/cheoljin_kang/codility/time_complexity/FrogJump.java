package hackerrank.cheoljin_kang.codility.time_complexity;

/*
    Problem source : https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJump {
    public static void main(String[] args) {
        int x = 10;
        int y = 85;
        int d = 30;
        System.out.println("result : " + solution(x, y, d));
    }

    static int solution(int X, int Y, int D) {
        int result = 0;
        int quotient = (Y - X) / D;
        int remainder = (Y - X) % D;
        if (remainder == 0) {
            result = quotient;
        } else {
            result = quotient + 1;
        }
        return result;
    }
}
