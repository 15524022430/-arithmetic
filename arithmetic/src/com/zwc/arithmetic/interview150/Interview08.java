package com.zwc.arithmetic.interview150;

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
     * 思路：考虑每天结束时的两种状态，持有股票和不持有股票，而这两种状态到当天的最大利润仅于前一天的两种状态的利润有关。
     * 1）在当天结束持有股票时，分为两种情况，股票是当天买的，则此时利润为前一天不持有股票的利润去掉当天股票的价格，
     * 或者股票不是当前买的，则此时利润为前一天持有股票的利润，在二者选大的，则为当天结束持有股票的最大利润
     * 2）在当天结束不持有股票也分为两种情况，股票是当天卖出的，则此时利润为前一天持有股票的利润加上当天股票的价格，
     * 或者股票不是当天卖出的，则此时利润为前一天不持有股票的利润，在二者选大的，则为当天结束不持有股票的最大利润
     * 可知，全部交易后，不持有股票的利润肯定大于持有股票的利润，则最后返回不持有股票的最大利润即为答案
     *
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices){
        int[][]dp=new int[prices.length][2];
        // dp[i][1]第i天持有的最多现金
        // dp[i][0]第i天持有股票后的最多现金
        dp[0][0]-=prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            // 第i天持股票所剩最多现金 = max(第i-1天持股票所剩现金, 第i-1天持现金-买第i天的股票)
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            // 第i天持有最多现金 = max(第i-1天持有的最多现金，第i-1天持有股票的最多现金+第i天卖出股票)
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return dp[prices.length-1][1];
    }
}
