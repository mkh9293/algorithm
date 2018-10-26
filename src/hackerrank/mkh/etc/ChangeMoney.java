package hackerrank.mkh.etc;

import java.util.Scanner;

public class ChangeMoney {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] coin = new int[n+10];
        
        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
        }
        int w = sc.nextInt();
        
        int[][] arr = new int[n+1][w+1];
        int max = Integer.MAX_VALUE;
        int ans  = solution(coin, arr, w, n);
        if(ans >= max) System.out.println("impossible");
        else System.out.println(ans);   
	}
	
	public static int solution(int[] coin, int[][] arr, int w, int n) {
		for(int i=1; i<=w; i++) arr[0][i] = Integer.MAX_VALUE;
		for(int i=0; i<=n; i++) arr[i][0] = 0;

		for(int i=1; i<=n; i++) {
			for(int j=1;j<=w; j++) { 
				if(coin[i]>j) {
					arr[i][j] = arr[i-1][j]; 
				} else if(arr[i-1][j] > arr[i][j-coin[i]]+1) {
					arr[i][j] = arr[i][j-coin[i]] + 1;
				} else {
					arr[i][j] = arr[i-1][j];
				}
			}

		}
		return arr[n][w];
	}
}
