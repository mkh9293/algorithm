package hackerrank.cheoljin_kang.kakao;

import java.util.Stack;

/*
    Problem source : https://programmers.co.kr/learn/courses/30/lessons/17682?language=java
 */
public class DartGame {
    public static void main(String[] args) {
        String s = "1D2S#10S";
        System.out.println(solution(s));
    }

    static int solution(String dartResult) {
        int result = 0;
        Stack<Integer> cal = new Stack();
        String[] arr = dartResult.split("");
        for (int i = 0; i < arr.length; i++) {
            if (isInteger(arr[i])) {
                if(isInteger(arr[i+1])) {
                    cal.push(10);
                    i++;
                } else {
                    cal.push(Integer.parseInt(arr[i]));
                }
            } else if (arr[i].equals("S")) {
                continue;
            } else if (arr[i].equals("D")) {
                int number = cal.pop();
                cal.push(number * number);
            } else if (arr[i].equals("T")) {
                int number = cal.pop();
                cal.push(number * number * number);
            } else if (arr[i].equals("*")) {
                int size = cal.size();
                if (size == 1) {
                    int number = cal.pop();
                    cal.push(number * 2);
                } else {
                    int number1 = cal.pop();
                    int number2 = cal.pop();
                    cal.push(number2 * 2);
                    cal.push(number1 * 2);
                }
            } else if (arr[i].equals("#")) {
                int number = cal.pop();
                cal.push(number * -1);
            }
        }
        int size = cal.size();
        for (int i = 0; i < size; i++) {
            int number = cal.pop();
            result += number;
        }
        return result;
    }

    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
