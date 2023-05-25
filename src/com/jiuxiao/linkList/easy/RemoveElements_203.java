package com.jiuxiao.linkList.easy;

import com.jiuxiao.model.ListNode;

/**
 * 203. 移除链表元素
 * @author: 悟道九霄
 * @date: 2023年05月09日 19:37
 * @version: 1.0.0
 */
public class RemoveElements_203 {

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     * <p>
     * 示例 2：
     * 输入：head = [], val = 1
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     * <p>
     * 提示：
     * 列表中的节点数目在范围 [0, 104] 内
     * 1 <= Node.val <= 50
     * 0 <= val <= 50
     * <p>
     * 思路：
     * 1. 设置一个虚拟节点指向 head 头结点，使用一个新的指针 ptr 遍历，初始化时指向虚拟节点
     * 2. 当遇到 ptr.next.val == val 时，说明遇到了与给定值相同的节点，需要删除
     * 3. 使用 ptr.next = ptr.next.next 进行删除
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dmy = new ListNode();
        ListNode ptr = dmy;
        dmy.next = head;
        while (ptr.next != null) {
            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return dmy.next;
    }
}