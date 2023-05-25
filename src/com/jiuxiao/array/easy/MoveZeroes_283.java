package com.jiuxiao.array.easy;

/**
 * 283. 移动零
 * @author: 悟道九霄
 * @date: 2023年05月08日 18:40
 * @version: 1.0.0
 */
public class MoveZeroes_283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * 提示:
     * 1 <= nums.length <= 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     * <p>
     * 思路：
     * 1. 快慢指针思路，设置两个指针 slow、fast，初始化时快慢指针均指向数组首位元素
     * 2. 慢指针 slow 指向结果数组的当前索引下标，快指针 fast 指向当前数组的下标
     * 3. 若 fast 当前指向元素不为 0，则将 fast 指向的值赋值给 slow 指针指向的值，然后 slow、fast 同时右移一位
     * 4. 若 fast 当前指向元素为 0，则 fast 右移一位
     * 5. 当 fast 走完之后，说明数组中所有元素均已遍历完毕，不断将 slow 右移，同时赋值为 0
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int slow = 0, fast = 0;
        while (slow <= fast && fast < n) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        while (slow < n) {
            nums[slow++] = 0;
        }
    }
}