package com.jiuxiao.linkList.medium;

import com.jiuxiao.model.ListNode;

/**
 * 19. 删除链表倒数第N和节点
 * @author: 悟道九霄
 * @date: 2023年05月12日 20:56
 * @version: 1.0.0
 */
public class RemoveNthFromEnd_19 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * <p>
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *  
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * <p>
     * 进阶：你能尝试使用一趟扫描实现吗？
     * <p>
     * 思路：
     * 1. 使用快慢指针法，初始化时 slow、fast 均指向 head
     * 2. 先让 fast 指针走 n 步, fast 走完 n 步之后:
     * --- 2.1 若 fast 指向的为 null，说明要删除的节点是链表第一个节点，直接返回 head.next
     * --- 2.2 若 fast 指向的不为 null，说明删除的是中间节点
     * 3. 若删除的为中间节点，则 slow、fast 一起走，直到 fast.next == null，此时 fast 已经指向链表末尾
     * 4. 此时 slow 指向的节点就是待删除结点的前驱结点，直接使用 slow.next = slow.next.next 进行删除即可
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //只有一个节点
        if (head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        //快指针先走 n 步
        while (n-- > 0) {
            fast = fast.next;
        }
        //删除的是第一个节点
        if (fast == null) {
            return head.next;
        }
        //删除的不是第一个节点，快慢指针一起走，直至 fast.next == null，此时已经到达链表末尾
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除指定结点
        slow.next = slow.next.next;
        return head;
    }
}