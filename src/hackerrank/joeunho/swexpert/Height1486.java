package hackerrank.joeunho.swexpert;

import java.util.*;

// sw expert Academy 1468
public class Height1486 {

    public static int min = Integer.MAX_VALUE;
    public static int b = 0;

    public static void main(String[] args) {
        int[] arr = {1,3,3,5,6};
        //int[] arr = {268, 61, 201, 535, 464, 168, 491, 275, 578, 153};
        int n =5;
        b =16;
        solution(0,0,arr);
        System.out.println("result : "+(min-b));
    }
    public static void solution(int now,int nowSum,int[] arr){
        if(nowSum>=b){
            min = Math.min(nowSum,min);
        }
        if(now==arr.length) return;

        solution(now+1,nowSum+arr[now],arr);
        solution(now+1,nowSum,arr);

    }

}
