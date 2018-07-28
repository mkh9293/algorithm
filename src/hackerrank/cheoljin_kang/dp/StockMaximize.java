package hackerrank.cheoljin_kang.dp;

/*
Problem
Your algorithms have become so good at predicting the market that
you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next number of days.

Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own,
or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?

For example, if you know that prices for the next two days are prices = [1,2],
you should buy one share day one, and sell it day two for a profit of 1.
If they are instead prices = [2,1], no profit can be made so you don't buy or sell stock those days.

Input Format
The first line contains the number of test cases t.
Each of the next  pairs of lines contain:
- The first line contains an integer n, the number of predicted prices for WOT.
- The next line contains n space-separated integers prices[i], each a predicted stock price for day i.

Constraints
1 <= t <= 10
1 <= n <= 50000
1 <= prices[i] <= 100000

Output Format
Output t lines, each containing the maximum profit which can be obtained for the corresponding test case.
*/
public class StockMaximize {
    public static void main(String[] args) {
        int[] prices1 = {5, 3, 2}; // result : 0
        int[] prices2 = {1, 2, 100}; // result : 197
        int[] prices3 = {1, 3, 1, 2}; // result : 3
        int[] prices4 = {8, 8, 8, 2, 2, 1, 6, 3, 3, 4}; // result : 15

        int result;
        result = solution(prices1);
        System.out.println("result 1 : " + result);

        System.out.println();

        result = solution(prices2);
        System.out.println("result 2 : " + result);

        System.out.println();

        result = solution(prices3);
        System.out.println("result 3 : " + result);

        System.out.println();

        result = solution(prices4);
        System.out.println("result 4 : " + result);
    }

    static int solution(int[] prices) {
        int maxPriceIndex = maxPriceIndex(prices, 0); // max price index number
        int count = 0; // price count
        int completeIndex = -1; // completed index number
        int buyPrice = 0; // buy price
        int benefit = 0; // total benefit
        while (completeIndex + 1 <= prices.length - 1) {
            for (int i = completeIndex + 1; i < maxPriceIndex; i++) {
                buyPrice += prices[i];
                count++;
            }
            completeIndex = maxPriceIndex;
            benefit = benefit + count * prices[maxPriceIndex] - buyPrice;
            buyPrice = 0;
            count = 0;
            if (completeIndex + 1 <= prices.length - 1) {
                maxPriceIndex = maxPriceIndex(prices, completeIndex + 1);
            }
        }
        return benefit;
    }

    static int maxPriceIndex(int[] prices, int startIndex) {
        int maxPriceIndex = startIndex;
        int maxPrice = prices[startIndex];
        for (int i = startIndex; i < prices.length; i++) {
            if (prices[i] >= maxPrice) {
                maxPrice = prices[i];
                maxPriceIndex = i;
            }
        }
        return maxPriceIndex;
    }
}
