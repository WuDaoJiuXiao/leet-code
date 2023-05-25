package com.jiuxiao.model;

/**
 * 数据结构定义：单链表
 * @author: 悟道九霄
 * @date: 2023年05月08日 20:49
 * @version: 1.0.0
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}