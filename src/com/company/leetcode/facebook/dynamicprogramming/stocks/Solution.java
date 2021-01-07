package com.company.leetcode.facebook.dynamicprogramming.stocks;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }


    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public int maxProfitTwoLoops(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0, n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = prices[0];
        for (int i = 1; i < prices.length; i++)
            buy[i] = Math.min(prices[i], buy[i-1]);

        sell[n - 1] = prices[n - 1];
        for (int j = n - 2; j >= 0; j--)
            sell[j] = Math.max(prices[j], sell[j + 1]);

        for (int i = 0; i < n; i++)
            max = Math.max(max, sell[i] - buy[i]);

        return max;
    }

    public int maxProfitBruteForce(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++)
            for (int j = i + 1; j < prices.length; j++)
                max = Math.max(max, prices[j] - prices[i]);
        return max;
    }
}
