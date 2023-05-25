package com.jiuxiao.linkList.medium;

import com.jiuxiao.model.ListNode;

/**
 * 24. 两两交换链表中的节点
 * @author: 悟道九霄
 * @date: 2023年05月12日 20:10
 * @version: 1.0.0
 */
public class SwapPairs_24 {

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * <p>
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     * <p>
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     * <p>
     * 思路：
     * 1. 设置一个虚拟头结点 dmy，初始化时 dmy.next = head
     * 2. 因为是每两个进行翻转，那么就需要定位到待翻转的两个节点的头一个节点，及 cur -> 待转1 -> 待转2
     * 3. 需要使用连个临时变量保存 待转1 和 待转2.next，因为进行翻转时这两个节点的 next 会丢失
     * 4. 当前两个节点翻转完成之后，cur 需要后移两位
     * 5. 循环的终止条件是：cur.next 为空（偶数节点）；cur.next.next 为空（奇数节点）
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dmy = new ListNode();
        dmy.next = head;
        ListNode cur = dmy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            ListNode post = temp.next.next;
            cur.next = temp.next;
            temp.next.next = temp;
            temp.next = post;
            cur = temp;
        }
        return dmy.next;
    }
}