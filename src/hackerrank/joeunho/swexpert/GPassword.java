package hackerrank.joeunho.swexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPassword {
    public static void main(String[] args) {
        //int[] arr = {9550, 9556, 9550, 9553, 9558, 9551, 9551, 9551};
        //int[] arr = {2419, 2418, 2423, 2415, 2422, 2419, 2420, 2415};
        //solution(arr);
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int[] arr = new int[8];
            int[] result = new int[8];
            int ts = sc.nextInt();

            for (int j = 0; j < 8; j++) {
                arr[j] = sc.nextInt();
            }

            result = solution(arr);

            System.out.print("#" + i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int[] arr){
        List<Integer> sb =  new ArrayList();
        int size = arr.length;
        for(int i:arr){
            sb.add(i);
        }

        boolean check = true;
        int reduction = 1;
        while (check){
            reduction = reduction%6;
            if(reduction == 0){
                reduction = 1;
            }
            int num = sb.get(0);
            num-=reduction;
            System.out.println("num : "+num);
            if(num<1){
                sb.remove(0);
                sb.add(0);
                break;
            }
            sb.remove(0);
            sb.add(num);
            reduction++;
        }

        int[] temp = new int[size];
        System.out.println("result");
        for(int i=0;i<size;i++){
            System.out.print(i+" ");
            temp[i] = sb.get(i);
        }

        return temp;
    }
}
