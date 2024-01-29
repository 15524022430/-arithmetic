package com.zwc.arithmetic.interview150;

/**
 * @author zhuwenchao
 * @date 2024-01-29 18:06
 * @DESCRIPTION  跳跃游戏1
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 */
public class Interview09 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i+nums[i], cover);
            if (cover >= nums.length -1){
                return true;
            }
        }
        return false;
    }
}
