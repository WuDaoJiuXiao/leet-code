package com.jiuxiao.linkList.easy;

import com.jiuxiao.model.ListNode;

/**
 * 206. 反转链表
 * @author: 悟道九霄
 * @date: 2023年05月11日 20:14
 * @version: 1.0.0
 */
public class ReverseList_206 {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * <p>
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     * <p>
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     * <p>
     * 提示：
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     */
    //迭代方式，双指针
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归写法（参考迭代的双指针方式）
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}