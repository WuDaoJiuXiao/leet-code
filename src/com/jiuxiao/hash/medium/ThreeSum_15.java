package com.jiuxiao.hash.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 悟道九霄
 * @Date 2023/5/25 21:11
 * @Description 15. 三数之和
 */
public class ThreeSum_15 {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * <p>
     * 示例 2：
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * <p>
     * 示例 3：
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * <p>
     * 提示：
     * 3 <= nums.length <= 3000
     * -10^5 <= nums[i] <= 10^5
     * <p>
     * 思路：
     * 1. 先对原数组 nums 进行排序
     * 2. 遍历排序后的数组，当前元素 nums[i] 看做 a 元素，首先要对 a 元素进行去重
     * 3. 当 a > 0时，不可能找到符合条件的 a、b、c，直接 return
     * 4. 当 nums[i] == nums[i - 1] 时，说明当前的 a 已经遍历过了，需要进行去重，此时循环直接 continue
     * 5. 针对当前元素 i 位置后面的元素，定义两个相向而行的双指针 left、right，其中初始化时 left = i + 1，right = nums.length - 1
     * 6. 当 left < right 时，进入 while 循环，计算当前三个元素的和 tempSum = a + b + c = nums[i] + nums[left] + nums[right]
     * 7. 若 tempSum > 0，则将右指针左移，减小和；当 tempSum < 0 时，将左指针右移，增大和；当 tempSum == 0 时，说明找到了符合条件的三个元素
     * 8. 接下来将符合条件的三个元素 a、b、c 加入结果列表中，然后对下一步的 b、c 进行去重
     * 9. 当满足 nums[left] == nums[left + 1] 时，说明 b 重复，left 指针不断右移
     * 10. 当满足 nums[right] == nums[right - 1] 时，说明 c 重复，right 指针不断左移
     * 11. 如此循环，直至所有的元素均遍历完成
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //对 a 进行去重：
            //1. 当前的 nums[i] 大于 0，直接 return，因为已经排序，所以根本找不到符合条件的数字
            //2. 如果当前的 nums[i] 等于 nums[i - 1]，则直接遍历下一个元素，对 a 进行去重
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //双指针遍历，寻找与 a 遍历的 b 和 c
            //若三数相加，和大于 0，右指针左移；小于 0，左指针右移；等于 0，对 b、c 进行去重
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                if (tempSum > 0) {
                    right--;
                } else if (tempSum < 0) {
                    left++;
                } else {
                    //将符合的三个数字加入结果集中
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //对 b、c 进行去重
                    while (left < right && nums[left] == nums[left + 1]) left++;    //对 b 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; //对 c 去重
                    //去重之后双指针相向移动，进入下一轮循环
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
