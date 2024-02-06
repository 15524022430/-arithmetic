package com.zwc.arithmetic.interview150;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author zhuwenchao
 * @date 2024-02-05 10:46
 * @DESCRIPTION  274题  h指数
 *
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个
 *
 *
 * 解题思路：
 * 这是我们可以想到，我们排序了之后，如果前面的论文能够满足至少被引用了h次，那么它后面的论文肯定也能够满足至少被引用了h次，
 * 因此我们需要在数组中找到最小的满足题目条件的论文。综上我们可以对数组从大到小进行遍历，将h初始化为0，如果引用次数＞h则h++，
 * 同时i--。一直到找到最后一个引用次数≥h的元素时遍历结束。因为此时前面的论文肯定不能够满足至少被引用了h次的条件。
 * 为什么是引用次数>h，因为其>h就意味着它至少被引用了h+1次，那就能够满足至少被引用了h次的条件
 */
public class Interview11 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h){
            h++;
            i--;
        }

        return h;
    }

}
