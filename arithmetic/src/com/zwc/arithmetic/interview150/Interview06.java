package com.zwc.arithmetic.interview150;

/**
 * @author: Zhuwenchao
 * @date: 2024/1/2 15:22
 * @description: 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class Interview06 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 13;

        rotate(nums, k);
    }

    /**
     * 生成一个新数组方法
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i< nums.length; i++){
            a[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i< a.length;i++){
            nums[i] = a[i];
        }
    }

    /**
     * 反转数字
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        //注意这里取余是为了避免发生数组越界异常，取余相当于移动了一圈然后又移动余数的位置
        k = k % nums.length;
        reversal(nums,0, nums.length-1);
        reversal(nums, 0, k - 1);
        reversal(nums, k, nums.length-1);
        for (int i =0;i< nums.length;i++) {
            System.out.print(nums[i]);
        }
    }
    public static void reversal(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
