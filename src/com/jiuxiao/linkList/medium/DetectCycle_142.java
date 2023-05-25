package com.jiuxiao.linkList.medium;

import com.jiuxiao.model.ListNode;

/**
 * 142. 环形链表II
 * @author: 悟道九霄
 * @date: 2023年05月13日 20:15
 * @version: 1.0.0
 */
public class DetectCycle_142 {

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况，不允许修改链表。
     * <p>
     * 示例 1：
     * 3 -> 2 -> 0 -> -4
     *      |__________|
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * 示例 2：
     * 1 -> 2
     * |____|
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     * <p>
     * 提示：
     * 链表中节点的数目范围在范围 [0, 10^4] 内
     * -10^5 <= Node.val <= 10^5
     * pos 的值为 -1 或者链表中的一个有效索引
     * <p>
     * 进阶：你是否可以使用 O(1) 空间解决此题？
     * <p>
     * 思路：
     * 1. 使用快慢指针的思想，初始化两个指针均指向链表头结点，slow 走一步，fast 走两步
     * 2. 想要解决该题目需要明白：1) fast 走过的路程永远等于两倍的 slow; 2) 若有环，则快慢指针一共要相遇两次
     * 3. 根据这个思想，如果链表存在环，那么如下分析，假设存在一个如下所示的链表，链表存在环，且环的入口点为 c 点
     * 4. 首先使用快慢指针寻找是否有环：fast走两步，slow走一步，因为如下链有环，那么 slow、fast 必在环内某个节点处相遇，针对如下链表，相遇点为 g 点
     * a -> b -> c -> d -> e -> f -> g -> h
     *           |________________________|
     * 5. 假设链表头结点到环入口点长度为 lenA  ==>  [a] -> [c] : 2
     * 6. 假设快慢指针第一次相遇点，距离环入口长度为 lenB  ==>  [c] -> [g] : 4
     * 7. 假设快慢指针第一次相遇点，尾部距离环入口长度为 lenB  ==> [g] -> [c] : 2
     * 8. 当快慢指针第一次相遇时：
     *      1) slow 指针走过的长度为 S_slow = lenA + lenB;
     *      2) fast 指着走过的长度为 S_fast = lenA + lenB + lenC + lenB
     *      3) 无论何时，fast 路程始终是 slow 的 2 倍，那么可以得出：lenA + lenB + lenC + lenB = 2 * (lenA + lenB)
     *      4) 整理上方等式可得：lenC = lenA
     * 9. 上述分析得，当快慢指针第一次相遇之后，fast 指针再走 lenA 长度，且 slow 再走 lenC 长度，两指针会再次相遇，且相遇点就是环入口点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        //寻找是否有环
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        //找环入口点
        if (hasCycle) {
            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        } else {
            return null;
        }
    }
}