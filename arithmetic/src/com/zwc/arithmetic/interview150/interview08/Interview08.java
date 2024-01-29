package com.zwc.arithmetic.interview150.interview08;

/**
 * @author zhuwenchao
 * @date 2024-01-23 18:09
 * @DESCRIPTION 买股票的最佳时机2
 *
 * 输入：prices = [7,1,5,3,6,4] 输出：7 解释：在第 2 天（股票价格 = 1）的时候买入，
 * 在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。 总利润为 4 + 3 = 7 。
 */
public class Interview08 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]){
                ans = ans + prices[i + 1] - prices[i];
            }
        }
        return ans;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices){
        int[][]dp=new int[prices.length][2];
        dp[0][0]-=prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return dp[prices.length-1][1];
    }
}
