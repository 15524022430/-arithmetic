package com.zwc.arithmetic.interview150;

/**
 * @author zhuwenchao
 * @date 2024-01-30 10:09
 * @DESCRIPTION
 */
public class Interview10 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        //表示当前位置能到达的最远位置
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            //如果达到了最远位置，进行跳跃
            if (end == i){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
