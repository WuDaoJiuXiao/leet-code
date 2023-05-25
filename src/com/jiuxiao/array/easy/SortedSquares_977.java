package com.jiuxiao.array.easy;

/**
 * 977. 有序数组的平方
 * @author: 悟道九霄
 * @date: 2023年04月24日 20:19
 * @version: 1.0.0
 */
public class SortedSquares_977 {

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <p>
     * 示例 1：
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * <p>
     * 示例 2：
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * <p>
     * 提示：
     * 1 <= nums.length <= 10^4
     * -10^4 <= nums[i] <= 10^4
     * nums 已按 非递减顺序 排序
     * <p> 
     * 进阶：
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     * <p>
     * 思路：
     * 1. 设置两个指针 left、right，left 指向数组第一个元素，right 指向数组最后一个元素
     * 2. 设置一个长度与 nums 相等的结果数组 res, 设置一个指针 index 指向 res 最后一位，用来将元素存入结果数组
     * 3. 当 left <= right 时，进入 while 循环
     * 4. 比较 left、right 两个指针当前所指元素的绝对值大小，将较大者的平方存储进结果数组 res 中，index 左移一位，等待下次存储
     * 5. 指向较大者的指针移动一位（若是 left 指针，则右移一位；否则左移一位）
     * 6. 不断进行，直至跳出 while 循环
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        if (n == 1) return new int[]{nums[0] * nums[0]};
        int[] res = new int[n];
        int index = n - 1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int leftAbs = Math.abs(nums[left]);
            int rightAbs = Math.abs(nums[right]);
            if (leftAbs >= rightAbs) {
                res[index--] = leftAbs * leftAbs;
                left++;
            } else {
                res[index--] = rightAbs * rightAbs;
                right--;
            }
        }
        return res;
    }
}