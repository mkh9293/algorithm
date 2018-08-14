package hackerrank.mkh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConstructArray {
	static long countArray(int n, int k, int x) {
		long prev1 = 1 , cur1 = 1;
		long prev2 = 0 , cur2 = 0;
		long result = 0;
		int mod = 1000000007;
		
		for(int i=1; i<n; i++) {
			cur1 = ((k-1) * prev2) % mod; // 처음과 끝이 같을 경우
			cur2 = ((k-2) * prev2 + prev1) % mod;
			prev1 = cur1;
			prev2 = cur2;
		}
		
		if(x == 1) result = cur1;
		else result = cur2;
		
		return result;
	}
	
	public static void main(String[] args) {
////		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		Scanner scanner = new Scanner(System.in);
        String[] nkx = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkx[0]);

        int k = Integer.parseInt(nkx[1]);

        int x = Integer.parseInt(nkx[2]);

        long answer = countArray(n, k, x);
        System.out.println(answer);
//        bufferedWriter.write(String.valueOf(answer));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
	
	}
	

}
