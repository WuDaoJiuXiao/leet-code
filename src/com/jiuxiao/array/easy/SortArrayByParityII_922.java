package com.jiuxiao.array.easy;

/**
 * 922. 按奇偶排序数组 II
 * @author: 悟道九霄
 * @date: 2023年05月08日 20:31
 * @version: 1.0.0
 */
public class SortArrayByParityII_922 {

    /**
     * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
     * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
     * 你可以返回 任何满足上述条件的数组作为答案 。
     * <p>
     * 示例 1：
     * 输入：nums = [4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     * <p>
     * 示例 2：
     * 输入：nums = [2,3]
     * 输出：[2,3]
     * <p>
     * 提示：
     * 2 <= nums.length <= 2 * 10^4
     * nums.length 是偶数
     * nums 中一半是偶数
     * 0 <= nums[i] <= 1000
     * <p>
     * 进阶：可以不使用额外空间解决问题吗？
     * <p>
     * 思路：
     * 1. 双指针解法，设置两个指针 left、right，初始化时 left = 0, right = 1
     * 2. 当满足 left 指向的当前元素是偶数时，left 不断右移两位(left += 2)，直到 left 指向奇数
     * 3. 当满足 right 指向的当前元素是奇数时，right 不断右移两位(right += 2)，直到 right 指向偶数
     * 4. 当 left、right 均停止本轮移动时，说明 left 指向的是奇数，right 指向的是偶数，需要交换，将两个指针的值交换
     * 5. 交换之后 left、right 均进行两位的右移，开始下一轮的比较
     */
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        while (left < n && right < n) {
            while (left < n && nums[left] % 2 == 0) left += 2;
            while (right < n && nums[right] % 2 != 0) right += 2;
            if (left < n && right < n) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left += 2;
            right += 2;
        }
        return nums;
    }
}