package com.jiuxiao.array.easy;

/**
 * 704. 二分查找
 * @author: 悟道九霄
 * @date: 2023年04月24日 16:57
 * @version: 1.0.0
 */
public class BinarySearch_704 {

    /**
     * 704. 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 示例 1:
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * <p>
     * 示例 2:
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * <p>
     * 提示：
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     */
    public int search(int[] nums, int target) {    //区间定义：左闭右闭
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;    //当前值比 target 大，说明 target 在左区间，右边界缩小
            } else if (nums[mid] < target) {
                left = mid + 1;     //当前值比 target 小，说明 target 在右区间，左边界缩小
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {    //区间定义：左闭右开
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}