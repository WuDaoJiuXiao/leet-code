package com.jiuxiao.array.medium;

/**
 * 59. 螺旋矩阵II
 * @author: 悟道九霄
 * @date: 2023年04月26日 20:06
 * @version: 1.0.0
 */
public class GenerateMatrix_59 {

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 
     * <p>
     * 示例 1：
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * <p>
     * 示例 2：
     * 输入：n = 1
     * 输出：[[1]]
     * <p>
     * 提示：
     * 1 <= n <= 20
     * <p>
     * 思路：
     * 1. 没有什么技巧，直接模拟即可
     * 2. 设置一个变量 num 表示当前应当填入的数字，循环条件为 while(num <= n * n)
     * 2. 设置四个变量 left、right、top、bottom 来控制循环边界，每循环完一行（列）数据，循环边界改变
     * 3. 假设当前循环是从 A 到 B，沿着 C 边循环，那么循环公式为(其他情况以此类推)
     * for (int i = A; i <= B; i++){ nums[C][i] = num++;} C++;
     */
    public int[][] generateMatrix(int n) {
        if (n == 1) return new int[][]{{1}};
        int top = 0, right = n - 1, bottom = n - 1, left = 0;
        int num = 1;
        int[][] res = new int[n][n];
        while (num <= n * n) {
            //从 left 往 right，沿着 top 边
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            //从 top 往 bottom，沿着 right 边
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            //从 right 往 left，验证 bottom 边
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            //从 bottom 到 top，沿着 left 边
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}