package com.jiuxiao.array.easy;

/**
 * 35.搜索插入位置
 * @author: 悟道九霄
 * @date: 2023年04月24日 18:17
 * @version: 1.0.0
 */
public class SearchInsert_35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * 示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * <p>
     * 示例 3:
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * <p>
     * 提示:
     * 1 <= nums.length <= 10^4
     * -10^4 <= nums[i] <= 10^4
     * nums 为 无重复元素 的 升序 排列数组
     * -10^4 <= target <= 10^4
     * <p>
     * 思路：
     * 1. 经典的二分查找方式，唯一不同之处在于最后在数组中找不到对应的值时，需要特殊处理
     * 2. 当数组中找到该值时，返回 mid
     * 3. 当数组中找不到该值时，有以下几中情况：
     * ---- a. 要寻找的值比数组所有元素都要小，此时插入位置为 0（跳出 while 循环时，right = mid - 1 = -1，那么插入位置就是 right + 1 = 0）
     * ---- b. 要寻找的值比数组所有元素都要大，此时插入位置为 nums.length（跳出 while 循环时，right = nums.length - 1 < left，那么插入位置就是 nums.length - 1 + 1 = right + 1）
     * ---- c. 要寻找的指在比数组中一个值 nums[k] 大，比另外一个值 nums[p] 小（跳出 while 循环时, right = mid - 1 < left，那么插入位置就是 right + 1）
     * 4. 故，当数组中找不到该值时，应该返回 right + 1
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }
}