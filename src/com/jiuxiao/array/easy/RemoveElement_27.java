package com.jiuxiao.array.easy;

/**
 * 27. 移除元素
 * @author: 悟道九霄
 * @date: 2023年04月24日 19:36
 * @version: 1.0.0
 */
public class RemoveElement_27 {

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1：
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     * <p>
     * 示例 2：
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     *  
     * 提示：
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     * <p>
     * 思路：
     * 1. 设置两个指针 left、right，left 指向数组第一个元素，right 指向数组最后一个元素
     * 2. 当 left 所指向的数值不等于 val 时，表示不需要替换，左指针 left 不断右移
     * 3. 当 right 所指向的数值等于 val 时，表示不需要替换，右指针 right 不断左移
     * 4. 经过一轮移动之后，left 指向的值等于 val，需要删除；right 指向的值不等于 val，需要保留
     * 5. 将 right 指针所指向的值赋值给 left 指针所指向的值，将 left 处等于 val 的值直接覆盖
     * 6. 覆盖完成之后，将 left 右移一位，right 左移一位，继续下一轮的寻找
     * 7. 遍历完毕之后，left 指针指向的索引，就是 nums 数组最后保留的长度
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] != val) left++;
            while (left <= right && nums[right] == val) right--;
            if (left <= right) {
                nums[left++] = nums[right--];
            }
        }
        return left;
    }
}