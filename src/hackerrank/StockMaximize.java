package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StockMaximize {

    // Complete the stockmax function below.
    static long stockmax(int[] prices) {
        // prices의 배열이 0보다 작으면 0리턴.
        int priceLen = prices.length;
        
        // 내가 보유한 주식 수
        int myStock = 0;
        
        // 내가 소비한 금액
        long spendMoney = 0;
        
        // 해당하는 일의 주식가격
        long stockPrice = 0;
        
        long profit = 0;
        
        for(int i=0;i<priceLen;i++) {
            // 주식 가격이 증가하는지 체크
            boolean stockCheck = false; 
            stockPrice = prices[i];
            for(int j=i;j<priceLen;j++){
                if(stockPrice < prices[j]) {
                    stockCheck = true;
                    break;
                }
            }
            
            // 주식의 가격이 올라갈 경우 주식 구매
            if(stockCheck) {
                myStock++;
                spendMoney+=stockPrice;
            } else {
                // 오르지 않을 경우, 팔거나 아무것도 하지 않음
                if(myStock > 0) {
                    profit += ((myStock * stockPrice) - spendMoney);
                    spendMoney = myStock = 0;
                }
            }
        }

        return profit;
    }


    public static void main(String[] args) throws IOException {
//    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\lg\\Desktop\\input"));
    	
    	Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] prices = new int[n];

            String[] pricesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            long result = stockmax(prices);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
