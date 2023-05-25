package com.jiuxiao.linkList.medium;

import com.jiuxiao.model.ListNode;

/**
 * 143. 重排链表
 * @author: 悟道九霄
 * @date: 2023年05月16日 19:48
 * @version: 1.0.0
 */
public class ReorderList_143 {

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[1,4,2,3]
     * <p>
     * 示例 2：
     * 输入：head = [1,2,3,4,5]
     * 输出：[1,5,2,4,3]
     * <p>
     * 提示：
     * 链表的长度范围为 [1, 5 * 10^4]
     * 1 <= node.val <= 1000
     * <p>
     * 思路：
     * 1. 先使用快慢指针思想找到链表的中点，此时慢指针 slow 的下一个节点我们称之为后半段链表
     * 2. 后半段链表进行翻转，得到一个新的链表
     * 3. 将新的链表一次插入到原链表的前半部分中，即可实现链表重排
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //快慢指针找到链表中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后半段链表
        ListNode need = slow.next;
        slow.next = null;
        //将反转后的半截链表一次插入到前半段链表中
        ListNode ptrA = head, ptrB = reverseList(need);
        while (ptrB != null) {
            ListNode temp = ptrA.next;
            ListNode dis = ptrB;
            ptrB = ptrB.next;
            ptrA.next = dis;
            dis.next = temp;
            ptrA = ptrA.next.next;
        }
    }

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
}