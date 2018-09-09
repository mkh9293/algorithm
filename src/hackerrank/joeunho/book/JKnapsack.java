package hackerrank.joeunho.book;

import java.util.Scanner;

public class JKnapsack {

    public static void main(String[] args) {
        int n = 6;
        int w = 11;
        int[][] M = new int[n][w];
        for(int i=0;i<w;i++){
            M[0][i]=0;
        }

        int[] W = {0,3,4,1,2,3};
        int[] V = {0,2,3,2,3,6};

        for(int i=1;i<n;i++){
            for(int j=0;j<w;j++){
                if(W[i]>j){
                    M[i][j]=M[i-1][j];
                }else{
                    M[i][j]=Math.max(M[i-1][j],V[i]+M[i-1][j-W[i]]);
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<w;j++){
               System.out.print(M[i][j]+" ");
            }
        }
        System.out.println();

    }
}
