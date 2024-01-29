package com.zwc.arithmetic.interview150;

/**
 * @author: Zhuwenchao
 * @date: 2023/12/19 11:14
 * @description: 移除元素
 */
public class Interview02 {
    public static void main(String[] args) {
        int[] nums = {1,3,3,5,6,8};
        int i = removeElement(nums, 3);
        System.out.println("数组长度："+i);

        int[] nums1 = {1,3,3,5,6,8};
        int i1 = removeElement02(nums1, 3);
        System.out.println(i1);
    }

    public static int removeElement(int[] nums, int val) {

        if (0 > nums.length || nums.length > 100){
            return 0;
        }
        if (0 > val || val > 100){
            return 0;
        }
        int size = nums.length;
        for (int i = 0; i < size;i++){
            if (0 > nums[i] || nums[i] > 50){
                return 0;
            }
            if (nums[i] == val){
                //如果相等就将后一个元素移到这个
                for (int j = i + 1; j<nums.length;j++){
                    nums[j-1] = nums[j];
                }
                //移动了一个，所以数组长度减少
                i--;
                size--;
            }

        }

        return size;
    }

    /**
     * 双指针解法
     * 思路：两个指针都从头开始，如果遇到相等的，快指针就向后移，并把该位置的值给慢指针，不相等就两个都移。最后取慢指针的大小
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement02(int[] nums, int val) {
        if (0 > nums.length || nums.length > 100){
            return 0;
        }
        if (0 > val || val > 100){
            return 0;
        }
        int slowIdx = 0;
        for (int fastIdx = 0;fastIdx<nums.length;fastIdx++){
            if (nums[fastIdx] > 50){
                return 0;
            }
            if (nums[fastIdx] != val){
                nums[slowIdx] = nums[fastIdx];
                slowIdx++;
            }
        }

        return slowIdx;
    }

}
