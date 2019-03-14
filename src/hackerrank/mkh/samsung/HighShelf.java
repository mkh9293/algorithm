package hackerrank.mkh.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HighShelf {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=count; i++) {
			String[] line1 = br.readLine().split(" ");
			int[] arr = new int[Integer.parseInt(line1[0])];
			int shelf = Integer.parseInt(line1[1]);
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int j = 0;
			while(st.hasMoreTokens()) {
				arr[j++] = Integer.parseInt(st.nextToken());
			}
			
			// solution
			int result = solution(shelf, arr);
			
			System.out.println("#"+i+" "+result);
		}
		
	}
	
	public static int solution(int shelf, int[] arr) {
		int max = Integer.MAX_VALUE;
		int temp = 0;
		Arrays.sort(arr);

		for(int i=arr.length-1; i>=0; i--) {
			if((shelf - arr[i]) > 0) {
				shelf -= arr[i];
				
				if(temp > 0) break;
			} else if(shelf < arr[i]){
				temp = Math.abs(shelf - arr[i]); // 양수로 만듬.
				max = Math.min(max, temp);
				
			}
			
		}
		
		return max;
	}
}
