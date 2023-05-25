package com.jiuxiao.array.easy;

import java.util.*;

/**
 * 1207. 独一无二的出现次数
 * @author: 悟道九霄
 * @date: 2023年05月08日 17:55
 * @version: 1.0.0
 */
public class UniqueOccurrences_1207 {

    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * <p>
     * 示例 1：
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * <p>
     * 示例 2：
     * 输入：arr = [1,2]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     * <p>
     * 提示：
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     * <p>
     * 思路：
     * 1. 使用一个 HashMap 统计员数组 arr 中每个元素出现的次数
     * 2. 将 HashMap 的 values 转为 HashSet，判断转换后的 set 尺寸是否与 HashMap 一致
     * 3. 若尺寸一致，则说明不存在出现次数相同的元素；否则存在
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int value : arr) {
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, 1);
            } else {
                int count = hashMap.get(value);
                hashMap.put(value, count + 1);
            }
        }
        HashSet<Integer> hashSet = new HashSet<>(hashMap.values());
        return hashMap.size() == hashSet.size();
    }
}