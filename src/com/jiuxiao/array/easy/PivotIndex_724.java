package com.jiuxiao.array.easy;

/**
 * 724. 寻找数组的中心下标
 * @author: 悟道九霄
 * @date: 2023年05月08日 19:28
 * @version: 1.0.0
 */
public class PivotIndex_724 {

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     * <p>
     * 示例 1：
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     * <p>
     * 示例 2：
     * 输入：nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心下标。
     * <p>
     * 示例 3：
     * 输入：nums = [2, 1, -1]
     * 输出：0
     * 解释：
     * 中心下标是 0 。
     * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
     * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
     *  
     * 提示：
     * 1 <= nums.length <= 10^4
     * -1000 <= nums[i] <= 1000
     * <p>
     * 思路：
     * 1. 先计算出整个数组所有元素的和 sum
     * 2. 依次遍历数组元素，分别计算当前位置 i 的左右子数组的和 leftSum、rightSum
     * 3. 其中 leftSum = leftSum + nums[i]、rightSum = sum - nums[i] - leftSum
     * 4. 当两个子区间和 leftSum == rightSum 时，表示找到了最左边的中心下标
     * 5. 若数组遍历结束时，leftSum != rightSum 依然不成立，则说明数组无中心下标，返回 -1
     */
    public int pivotIndex(int[] nums) {
        int sum = 0, n = nums.length;
        if (n == 1) return 0;
        for (int num : nums) sum += num;

        int leftSum = 0, rightSum = sum - nums[0];
        if (leftSum == rightSum) return 0;
        for (int i = 1; i < n; i++) {
            leftSum += nums[i - 1];
            rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}