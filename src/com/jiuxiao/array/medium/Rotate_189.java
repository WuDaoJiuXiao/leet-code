package com.jiuxiao.array.medium;

/**
 * 189. 轮转数组
 * @author: 悟道九霄
 * @date: 2023年05月08日 19:11
 * @version: 1.0.0
 */
public class Rotate_189 {

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 示例 2:
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     * <p>
     * 提示：
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 10^5
     * <p>
     * 思路：
     * 1. 根据所给的轮转步长 k 以及数组长度 n，计算出实际需要轮转的步长 step
     * 2. 以 step 所对应的下标为分界线，将数组 nums 分为左右两个左闭右闭的区域 [0, n - step - 1]、[n - step, n - 1]
     * 3. 分别将左右两个区域的数组元素反转，最后再将整个 nums 数组反转，得到的结果就是轮转 k 步之后的结果
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int step = k % n;   //实际轮转步长
        //以步长为分界点，左、右区域均反转
        //反转左半部分
        exchange(nums, 0, n - step - 1);
        //反转右半部分
        exchange(nums, n - step, n - 1);
        //最后整体反转
        exchange(nums, 0, n - 1);
    }

    //反转数组，[left, right]，区间左闭右闭
    private void exchange(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}