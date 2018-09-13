package hackerrank.mkh.dp;

public class Knapsack2 {
	public static void main(String[] args) {
		int[] w = {1,2,3,4};
		int[] p = {5,7,8,9};
		int size = w.length;
		int max = 5, ret = 0;
		int[][] arr = new int[size+1][max+1];
		
		for(int i=0; i<w.length; i++) {
			for(int j=0; j<=max; j++) {
				if(j+w[i] <= max) {
					arr[i+1][j+w[i]] = Math.max(arr[i+1][j+w[i]], arr[i][j]+p[i]);
					ret = Math.max(arr[i+1][j+w[i]], ret);
				} else {
					break;
				}
			}
		}
		System.out.println(ret);
	}
}
