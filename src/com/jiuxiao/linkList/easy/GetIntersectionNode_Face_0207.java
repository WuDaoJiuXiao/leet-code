package com.jiuxiao.linkList.easy;

import com.jiuxiao.model.ListNode;

/**
 * 面试题02.07. 链表相交
 * @author: 悟道九霄
 * @date: 2023年05月13日 19:46
 * @version: 1.0.0
 */
public class GetIntersectionNode_Face_0207 {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * A :          a1 -> a2
     * \
     * c1 -> c2 -> c3
     * /
     * B :    b1 -> b2 -> b3
     * <p>
     * 题目数据 保证 整个链式结构中不存在环。
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     * <p>
     * 示例 1：
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * <p>
     * 示例 2：
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Intersected at '2'
     * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
     * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     * <p>
     * 示例 3：
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
     * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 这两个链表不相交，因此返回 null 。
     * <p>
     * 提示：
     * listA 中节点数目为 m
     * listB 中节点数目为 n
     * 0 <= m, n <= 3 * 10^4
     * 1 <= Node.val <= 10^5
     * 0 <= skipA <= m
     * 0 <= skipB <= n
     * 如果 listA 和 listB 没有交点，intersectVal 为 0
     * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
     * <p>
     * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
     * <p>
     * 思路：
     * 一、交集思想
     * 1. 假设链表 A 相交之前长度为 a，B 相交之前长度为 b，相交的长度为 c
     * 2. 则有关系：a + c + b = b + c + a，即当前链表总长度 + 另一个链表的相交之前的长度，总的步数是一致的
     * 3. 因此使用两个指针分别指向 A、B 头结点，分别走过 a + b + c 的路程后，两个指针将会相遇，相遇的节点就是两个链表的相交节点
     * 二、双指针思想
     * 1. 分别使用两个双指针遍历的到两个链表总长度 lenA、lenB
     * 2. 先让长度较长的链表的指针走 num 步，其中 num = Math.abs(lenA - lenB)
     * 3. 然后两个指针一起走，当两指针相遇的时候，就是两个链表相交的节点
     */
    //交集思想
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA, ptr2 = headB;
        while (ptr1 != ptr2) {
            ptr1 = ptr1 == null ? headB : ptr1.next;
            ptr2 = ptr2 == null ? headA : ptr2.next;
        }
        return ptr2;
    }

    //双指针思想
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA, ptr2 = headB;
        int lenA = 0, lenB = 0;
        while (ptr1 != null) {
            lenA++;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            lenB++;
            ptr2 = ptr2.next;
        }
        ptr1 = headA;
        ptr2 = headB;
        int step = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (step-- > 0) {
                ptr1 = ptr1.next;
            }
        } else {
            while (step-- > 0) {
                ptr2 = ptr2.next;
            }
        }
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }
}