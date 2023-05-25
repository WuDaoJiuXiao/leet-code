package com.jiuxiao.array.medium;

/**
 * 209. 最小长度的子数组
 * @author: 悟道九霄
 * @date: 2023年04月26日 15:29
 * @version: 1.0.0
 */
public class MinSubArrayLen_209 {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [nums_l, nums_l+1, ..., nums_r-1, nums_r] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * <p>
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * <p>
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * <p>
     * 提示：
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     * <p>
     * 思路：
     * 1. 遍历数组，在遍历的同时使用 sum 计算当前遍历过的元素的和
     * 2. 当 sum >= target 时，说明已经找到了一个满足条件的连续子数组，计算子数组的长度 len
     * 3. 比较子数组长度 len 和当前最短子数组长度 res，取两者最小值为 res
     * 4. sum 减去当前窗口的最左边界的值，然后左边界右移一位
     * 5. 直至整个数组被遍历结束
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return target >= nums[0] ? 0 : 1;
        }
        int sum = 0, res = Integer.MAX_VALUE, child = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - child + 1);
                sum -= nums[child++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}