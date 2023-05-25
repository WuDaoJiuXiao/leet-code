package com.jiuxiao.hash.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * @author: 悟道九霄
 * @date: 2023年05月16日 20:09
 * @version: 1.0.0
 */
public class Intersection_349 {

    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * <p>
     * 示例 2：
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 解释：[4,9] 也是可通过的
     * <p>
     * 提示：
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     * <p>
     * 思路：
     * 1. 定义一个结果集合 set, 先遍历一遍数组 nums1，对 nums1 建立一个每个元素个数的哈希表
     * 2. 遍历 nums2，如果 nums2[i] 在哈希表的 key 中，则说明属于交集，加入结果集合 set 中
     * 3. 最后将 set 转为数组返回即可
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                set.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}