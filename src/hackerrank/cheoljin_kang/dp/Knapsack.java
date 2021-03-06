package hackerrank.cheoljin_kang.dp;

import java.util.HashMap;
import java.util.Map;

/*
Problem
Given an array of integers and a target sum,
determine the sum nearest to but not exceeding the target that can be created.
To create the sum, use any element of your array zero or more times.

For example, if arr = [2,3,4] and your target sum is 10,
you might select [2,2,2,2,2], [2,2,3,3] or [3,3,4].
In this case, you can arrive at exactly the target.

Input Format

The first line contains an integer t, the number of test cases.

Each of the next t pairs of lines are as follows:
- The first line contains two integers n and k, the length of arr and the target sum.
- The second line contains n space separated integers arr[i].

Constraints
1 <= t <= 10
1 <= n,k,arr[i] <= 2000

Output Format
Print the maximum sum for each test case which is as near as possible,
but not exceeding, to the target sum on a separate line.
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] arr1 = {1, 6, 9};
        int k1 = 12;
        int[] arr2 = {8, 4, 4, 4, 3};
        int k2 = 9;
        int[] arr3 = {2, 3, 7};
        int k3 = 43;
        int[] arr4 = {3, 3, 3, 3, 3, 3};
        int k4 = 8;
        int[] arr5 = {4, 7};
        int k5 = 22;
        int[] arr6 = {3, 6, 7, 11, 12};
        int k6 = 13;

        System.out.println(knapsack(arr1, k1));
    }

    static int knapsack(int[] nums, int k) {

        return knapsack(nums, k, 0, new HashMap<>());
    }

    static int knapsack(int[] nums, int k, int prev, Map<String, Integer> memo) {
        String key = k + "|" + prev;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int nextK = k - nums[i];
            if (k - nums[i] == 0) {
                max = Math.max(max, nums[i] + prev);
            } else if (k - nums[i] < 0) {
                max = Math.max(max, prev);
            } else {
                max = Math.max(max, knapsack(nums, nextK, nums[i], memo) + prev);
            }
        }
        memo.put(key, max);
        return max;
    }
}
