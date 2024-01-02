package com.zwc.arithmetic.interview150.interview05;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Zhuwenchao
 * @date: 2024/1/2 11:51
 * @description: 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class Interview05 {
    public static void main(String[] args) {
       int[] nums = {2,2,1,1,1,2,2};
       System.out.println(majorityElement(nums));
    }

    /**
     * map计数法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int a = -1;
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], Objects.isNull(map.get(nums[i])) ? 1 : map.get(nums[i]) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > (nums.length / 2)){
                a = entry.getKey();
            }
        }
        return a;
    }
}
