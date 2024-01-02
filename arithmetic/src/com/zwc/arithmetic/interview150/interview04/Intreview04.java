package com.zwc.arithmetic.interview150.interview04;

/**
 * @author: Zhuwenchao
 * @date: 2023/12/27 10:15
 * @description: 删除有序数组中的重复项 II
 */
public class Intreview04 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2){
            return nums.length;
        }
        int fastIdx = 2;
        int slowIdx = 1;
        while (fastIdx < nums.length){
            if (nums[fastIdx] != nums[slowIdx - 1]){
                slowIdx ++;
                nums[slowIdx] = nums[fastIdx];
            }
            fastIdx ++;
        }
        return ++slowIdx;
    }
}
