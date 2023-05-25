package com.jiuxiao.hash.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 悟道九霄
 * @Date 2023/5/23 19:21
 * @Description 1. 俩数之和
 */
public class TwoSum_1 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * <p>
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * <p>
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * <p>
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * <p>
     * 提示：
     * 2 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= target <= 10^9
     * 只会存在一个有效答案
     * <p>
     * 思路：
     * 1. 创建一个 HashMap，存储的数据为当前元素值及其下标
     * 2. 遍历 nums 数组，如果 target - 当前值 包含在 hashMap 的 Key 中，则说明找到了和为 target 的俩数，返回俩数的下标
     * 3. 若没有匹配的 key，则将当前元素值及其下标存入 hashMap 中
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
