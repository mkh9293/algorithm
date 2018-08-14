package hackerrank.joeunho.algorithms.dp;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        int[] arr ={3, 4, 4, 4, 8};
        int result=unboundedKnapsack(9,arr);
        System.out.println(result);
    }

    public static int unboundedKnapsack(int k, int[] arr) {

        int[] knapsack=new int[k+1];
        for(int i=1;i<=k;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]<=i)
                {
                    knapsack[i]=Math.max(knapsack[i],arr[j]+knapsack[i-arr[j]]);
                }
            }
        }
        return knapsack[k];
    }
}
