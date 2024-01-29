package com.zwc.arithmetic.interview150.interview07;

/**
 * @author zhuwenchao
 * @date 2024-01-17 18:26
 * @DESCRIPTION 买股票的最佳时机1
 *
 * 贪心算法的基本思路是从问题的某一个初始解出发一步一步地进行，根据某个优化测度，
 * 每一 步都要确保能获得局部最优解。每一步只考虑一 个数据，其选取应该满足局部优化的条件。
 * 若下 一个数据和部分最优解连在一起不再是可行解时， 就不把该数据添加到部分解中，直到把所有数据枚举完，或者不能再添加算法停止。 [9]
 * 贪心算法一般按如下步骤进行： [2]
 * ①建立数学模型来描述问题 [2]。
 * ②把求解的问题分成若干个子问题 [2]。
 * ③对每个子问题求解，得到子问题的局部最优解 [2]。
 * ④把子问题的解局部最优解合成原来解问题的一个解 [2]。
 *
 *
 * 贪心算法是一种对某些求最优解问题的更简单、更迅速的设计技术。
 * 贪心算法的特点是一步一步地进行，常以当前情况为基础根据某个优化测度作最优选择，而不考虑各种可能的整体情况，
 * 省去了为找最优解要穷尽所有可能而必须耗费的大量时间。贪心算法采用自顶向下，以迭代的方法做出相继的贪心选择，
 * 每做一次贪心选择，就将所求问题简化为一个规模更小的子问题，通过每一步贪心选择，可得到问题的一个最优解。
 * 虽然每一步上都要保证能获得局部最优解，但由此产生的全局解有时不一定是最优的，所以贪心算法不要回溯 [2]
 *
 *
 *
 * 本题使用贪心算法，因为不需要对情况进行回溯
 */
public class Interview07 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int i = maxProfit(prices);
        int i1 = maxProfit2(prices);
        System.out.println(i);
        System.out.println(i1);
    }
    public static int maxProfit(int[] prices) {
        //输出的答案
        int ans = 0;
        //先将int类型的最大值设为最小值，考虑数组比较
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++){
            //将数组的最小值替换
            min = min < prices[i - 1] ? min : prices[i - 1];
            if (min < prices[i]){
                int t = prices[i] - min;
                ans = ans > t ? ans : t;
            }
        }
        return ans;
    }

    /**
     * 使用动态规划算法
     * @return
     */
    public static int maxProfit1(int[] prices){
        int[][]dp=new int[prices.length][2];
        dp[0][0]-=prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return dp[prices.length-1][1];
    }


    public static int maxProfit2(int[] prices){
        //预设二维数组初始值
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        dp[0][1] = prices[0] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.min(dp[i-1][0], prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i] - dp[i-1][0]);
        }

        return dp[prices.length-1][1];
    }

}
