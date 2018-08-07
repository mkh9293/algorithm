package hackerrank.mkh;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Knapsack {

    // Complete the unboundedKnapsack function below.
    static int unboundedKnapsack(int k, int[] arr) {
    	
    	// 배열의 크기, 목표숫자 만큼의 2차원 배열 생성
    	int[][] caseArr = new int[arr.length][k];
    	
    	// 전체 배열 크기의 루프를 돌리면서 목표숫자만큼 더해나간다.
    	for(int i=0;i<arr.length;i++) {
    		int q = 0;
    		// 내부 루프는 테스트 케이스를 쌓으면서 + 해당 테스트 케이스를 이용하며 목표숫자만큼 더해나간다.
    		for(int j=0; q<=k;j++) {
    			
    			
    			q = Math.max(q, arr[i] + caseArr[i][j]);
    			caseArr[i][j] = q;
    		}
    	}
    	
    	return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    	
    	// 테스트케이스를 담을 2차원 배열을 만든다. 
    	// 해당 숫자가 목표 숫자보다 클 때까지 돌리면서 테스트 케이스를 쌓는다.
    	// 자기 자신이 목표숫자보다 커지면 기존에 쌓아뒀던 테스트 케이스에 자기자신을 더하면서 테스트 케이스를 쌓는다.
    	int[] arr = {3,6,7};
    	unboundedKnapsack(17, arr);
    	
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");   
//
//        for(int i = 0 ; i < t ; i++) {
//        	
//        	String[] nk = scanner.nextLine().split(" ");
//        	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");   
//        	
//            int n = Integer.parseInt(nk[0]);
//
//            int k = Integer.parseInt(nk[1]);
//
//            int[] arr = new int[n];
//
//            String[] arrItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//            
//            for (int j = 0; j < n; j++) {
//                int arrItem = Integer.parseInt(arrItems[j]);
//                arr[j] = arrItem;
//            }
//      
//            int result = unboundedKnapsack1(k, arr);
//            System.out.println(result);
//
//        }
               
        
       
//        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

//        scanner.close();
    }
}
