package com.jiuxiao.model;

/**
 * 数据结构定义：二叉树
 * @author: 悟道九霄
 * @date: 2023年05月08日 20:52
 * @version: 1.0.0
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}