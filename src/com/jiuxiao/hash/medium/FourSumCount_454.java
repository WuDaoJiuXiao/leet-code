package com.jiuxiao.hash.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 悟道九霄
 * @Date 2023/5/25 14:34
 * @Description 454. 四数相加II
 */
public class FourSumCount_454 {

    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
     * 输出：2
     * 解释：
     * 两个元组如下：
     * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
     * <p>
     * 示例 2：
     * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
     * 输出：1
     * <p>
     * 提示：
     * n == nums1.length
     * n == nums2.length
     * n == nums3.length
     * n == nums4.length
     * 1 <= n <= 200
     * -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
     * <p>
     * 思路：
     * 1. 使用一个 map 来进行辅助计算
     * 2. 首先遍历前两个数组 nums1、nums2，将俩个数组所有元素相加的和 sum，以及该和 sum 出现的次数 count 存如 map 中
     * 3. 然后遍历剩下的两个数组 nums3、nums4，计算所有元素相加的和 tempSum，在 map 中找是否存在 -tempSum
     * 4. 如果 Map 中存在 -tempSum，则说明找到了一组和为 0 的元素组合，最终的总结果 res 加上 map 中 -tempSum 所对应的 value
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        if (n == 1) {
            return nums1[0] + nums2[0] + nums3[0] + nums4[0] == 0 ? 1 : 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //统计前两个数组的元素之和，并统计该和出现的次数
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int temp = num1 + num2;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //遍历剩下的两个数组，同时查询 map 中已有的和是否相加为 0
        int res = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int tempSum = num3 + num4;
                if (map.containsKey(-tempSum)) {
                    res += map.get(-tempSum);
                }
            }
        }
        return res;
    }
}
