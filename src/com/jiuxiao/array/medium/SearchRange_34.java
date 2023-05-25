package com.jiuxiao.array.medium;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author: 悟道九霄
 * @date: 2023年04月24日 19:10
 * @version: 1.0.0
 */
public class SearchRange_34 {

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * <p>
     * 示例 2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * <p>
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     * <p>
     * 提示：
     * 0 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     * nums 是一个非递减数组
     * -10^9 <= target <= 10^9
     * <p>
     * 思路：
     * (1) 二分搜索 + 双指针
     * 1. 首先使用二分搜索法，在 nums 中寻找 target 的索引位置，若找到则返回索引 index, 否则返回 -1
     * 2. 当找到 target 在 nums 中的任意一个索引 index 时，以 index 为中心，使用双指针 left、right 向左右两边分别遍历，直至当前元素不等于 target 为止
     * 3. 在搜索时，关于 while 的边界条件，需要使用 >=、<=，因为与 target 值相同的元素，也有可能是 nums 数组的第一个和最后一个元素
     * 4. 此时 left、right 所指向的下标位置，就是 target 元素在数组中出现的第一个和最后一个位置
     * (2) 二分搜索 + 二分搜索：分别使用二分搜索分别寻找 target 的最左、最右边界
     */
    //二分搜索 + 双指针
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int index = binarySearch(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index, right = index;
        while (left >= 0 && nums[left] == target) left--;
        while (right <= n - 1 && nums[right] == target) right++;
        return new int[]{left + 1, right - 1};
    }

    private int binarySearch(int[] nums, int target) {
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
        return -1;
    }

    //二分搜索 + 二分搜索
    public int[] searchRange2(int[] nums, int target) {
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        return new int[]{-1, -1};
    }

    private int searchLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }

    private int searchRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
}