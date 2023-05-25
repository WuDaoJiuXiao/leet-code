package com.jiuxiao.array.easy;

/**
 * 941. 有效的山脉数组
 * @author: 悟道九霄
 * @date: 2023年05月08日 15:16
 * @version: 1.0.0
 */
public class ValidMountainArray_941 {

    /**
     * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
     * 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
     * 1. arr.length >= 3
     * 2. 在 0 < i < arr.length - 1 条件下，存在 i 使得：
     * 2.1 arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * 2.2 arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * <p>
     * 示例 1：
     * 输入：arr = [2,1]
     * 输出：false
     * <p>
     * 示例 2：
     * 输入：arr = [3,5,5]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：arr = [0,3,2,1]
     * 输出：true
     * <p>
     * 提示：
     * 1 <= arr.length <= 10^4
     * 0 <= arr[i] <= 10^4
     * <p>
     * 思路：
     * 1. 双指针思想，设置两个指针 left、right，分别指向数组首位、末尾
     * 2. 当满足 arr[i - 1] < arr[i]，即满足上山趋势时，left 不断右移
     * 3. 当满足 arr[i - 1] > arr[i]，即满足下山趋势时，right 不断左移
     * 4. 当且仅当 left 不指向首位、right 不指向末位时，判断两个指针是否指向同一个位置（山顶）
     */
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int left = 0, right = n - 1;
        //左指针上山
        while (left + 1 < n && arr[left] < arr[left + 1]) left++;
        //右指针上山
        while (right > 0 && arr[right] < arr[right - 1]) right--;
        //只有两指针相遇并且都不在起始位置，才是有山峰
        return left == right && left != 0 && right != n - 1;
    }
}