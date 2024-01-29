package com.zwc.arithmetic.interview150;

/**
 * @author: Zhuwenchao
 * @date: 2023/12/19 17:56
 * @description: 删除有序数组的重复项
 */
public class Interview03 {
    public static void main(String[] args) {
//        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        int nums[] = {1,1};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int size = nums.length;
        int slowIdx = 1;
        int fastIdx = 1;
        while (fastIdx < size){
            //如果不相等，就将快指针的值赋给慢指针，慢指针加一
            //要注意，该赋值操作是将快指针的不重复元素赋值过来，输出的数组内没有重复
            if (nums[fastIdx] != nums[fastIdx - 1]){
                nums[slowIdx] = nums[fastIdx];
                slowIdx++;
            }
            fastIdx++;
        }
        return slowIdx;
    }

    public static int removeDuplicates01(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int size = nums.length;
        int slowIdx = 1;
        for (int fastIdx = 1; fastIdx < size; fastIdx++){
            if (nums[fastIdx]!= nums[fastIdx - 1]){
                nums[slowIdx] = nums[fastIdx];
                slowIdx++;
            }
        }
        return slowIdx;
    }
}
