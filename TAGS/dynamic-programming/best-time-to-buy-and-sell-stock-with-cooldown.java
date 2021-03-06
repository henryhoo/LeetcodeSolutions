/*
 Say you have an array for which the i th element is the price of a given stock
on day i .  Design an algorithm to find the maximum profit. You may complete as
many transactions as you like
(ie, buy one and sell one share of the stock multiple times) with the following
restrictions:   You may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again).  After you sell your stock,
you cannot buy stock on next day. (ie, cooldown 1 day)   Example:  prices = [1,
2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]  Credits: Special thanks to
@dietpepsi for adding this problem and creating all test cases.   Subscribe to
see which companies asked this question    Show Tags   Dynamic Programming
Show Similar Problems   (E) Best Time to Buy and Sell Stock  (M) Best Time to
Buy and Sell Stock II
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[1], buy[0]);
        sell[1] = Math.max(prices[1]-prices[0], 0);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }

        return sell[prices.length - 1];
    }
}
