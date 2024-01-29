package com.zwc.arithmetic.interview150;

/**
 * @author: Zhuwenchao
 * @date: 2023/12/13 17:19
 * @description:  合并两个有序数组
 */
public class Interview01 {
    public static void main(String[] args) {
        int[] nums1 = {5,6,8,0,0,0};
        int[] nums2 = {2,3,9};

        merge(nums1, 3, nums2, 3);
    }

    /**
     * 思路：已经确定了nums1和nums2是有序的，nums1的长度是m+n，所以从数组的最后进行比较
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ints = processMerge(nums1, m, nums2, n);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i] +",");
        }
    }

    public static int[] processMerge(int[] nums1, int m, int[] nums2, int n){
        if (null == nums1 && null != nums2){
            return nums2;
        }
        if (null == nums2 && null != nums1){
            return nums1;
        }
        if (null == nums2 && null == nums1){
            return null;
        }
        //nums1的指针
        int idx1 = m-1;
        //nums2的指针
        int idx2 = n-1;
        //倒着排序，因为nums1有足够的长度，所以比较完都放入nums1中
        for (int i = m+n-1;i >= 0; i--){
            if (idx1 >= 0 && idx2 >= 0) {
                if (nums1[idx1] >= nums2[idx2]) {
                    nums1[i] = nums1[idx1];
                    idx1--;
                }
                else {
                    nums1[i] = nums2[idx2];
                    idx2--;
                }
            }else if (idx2 >= 0 && idx1 < 0){
                nums1[i] = nums2[idx2];
                idx2--;
            }else {
                break;
            }
        }
        return nums1;
    }

}
