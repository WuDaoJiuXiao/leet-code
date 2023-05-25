package com.jiuxiao.linkList.easy;

import com.jiuxiao.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文联表
 * @author: 悟道九霄
 * @date: 2023年05月16日 19:07
 * @version: 1.0.0
 */
public class IsPalindrome_234 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,2,1]
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：false
     * <p> 
     * 提示：
     * 链表中节点数目在范围[1, 10^5] 内
     * 0 <= Node.val <= 9
     * <p>
     * 思路：
     * 1. 将链表中所有元素装进数组中
     * 2. 使用双指针相向遍历，对比是否相等
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}