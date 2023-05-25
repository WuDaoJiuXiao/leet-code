package com.jiuxiao.array.easy;

/**
 * 1365. 有多少小于当前数字的数字
 * @author: 悟道九霄
 * @date: 2023年05月04日 21:24
 * @version: 1.0.0
 */
public class SmallerNumbersThanCurrent_1365 {

    /**
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     * 以数组形式返回答案。
     * <p>
     * 示例 1：
     * 输入：nums = [8,1,2,2,3]
     * 输出：[4,0,1,1,3]
     * 解释：
     * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
     * 对于 nums[1]=1 不存在比它小的数字。
     * 对于 nums[2]=2 存在一个比它小的数字：（1）。
     * 对于 nums[3]=2 存在一个比它小的数字：（1）。
     * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     * <p>
     * 示例 2：
     * 输入：nums = [6,5,4,8]
     * 输出：[2,1,0,3]
     * <p>
     * 示例 3：
     * 输入：nums = [7,7,7,7]
     * 输出：[0,0,0,0]
     * <p>
     * 提示：
     * 2 <= nums.length <= 500
     * 0 <= nums[i] <= 100
     * <p>
     * 思路：
     * (1) 暴力解法：
     * 看数据的范围只有 500，完全可以使用两个循环来暴力比较
     * (2) 使用桶排序的思想
     * 1. 因为数据最大范围才是 100，因此开辟一个长度为 101 的数组 temp，用来记录 nums 中每个元素出现的次数
     * 2. 遍历一遍 temp 数组，对于每个元素 i，对应的比他小的元素个数就是 temp[i] = temp[i - 1] + temp[i]
     * 3. 创建一个结果返回数组，长度为 nums.length，直接根据下标去 temp 数组中取对应的 temp[i]，就是比当前元素小的数的总个数
     */
    //暴力解法
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int num : nums) {
                if (num < nums[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    //使用桶排序的思想
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] temp = new int[101];
        int[] res = new int[nums.length];
        for (int num : nums) {
            temp[num]++;
        }
        for (int i = 1; i < 101; i++) {
            temp[i] += temp[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] > 0 ? temp[nums[i] - 1] : 0;
        }
        return res;
    }
}