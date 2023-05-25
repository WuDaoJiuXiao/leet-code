package com.jiuxiao.hash.easy;

/**
 * @Author 悟道九霄
 * @Date 2023/5/22 20:41
 * @Description 202. 快乐数
 */
public class IsHappy_202 {

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」 定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     * <p>
     * 示例 1：
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * <p>
     * 示例 2：
     * 输入：n = 2
     * 输出：false
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 2^31 - 1
     * <p>
     * 思路：
     * 1. 对于每个数，先将该数字进行位数分割，然后计算分割后每个位数的平方和
     * 2. 将该数字一致循环计算 10 次（本人也不是知道这个数字该是多大才好...）左右，只要有一次是 1，那么就是快乐数；否则就不是
     */
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int num = n;
        int count = 1;
        while (count < 10) {
            int temp = splitNum(num);
            if (temp != 1) {
                num = temp;
            } else {
                return true;
            }
            count++;
        }
        return false;
    }

    private int splitNum(int num) {
        int res = 0;
        while (num != 0) {
            int temp = num % 10;
            res += (temp * temp);
            num /= 10;
        }
        return res;
    }
}
