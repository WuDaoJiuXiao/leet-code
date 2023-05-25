package com.jiuxiao.hash.easy;

/**
 * 242. 有效的字母异位词
 * @author: 悟道九霄
 * @date: 2023年05月16日 20:01
 * @version: 1.0.0
 */
public class IsAnagram_242 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * <p>
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * <p>
     * 提示:
     * 1 <= s.length, t.length <= 5 * 10^4
     * s 和 t 仅包含小写字母
     * <p>
     * 思路：
     * 1. 如果俩个字符串长度不一致，则一定不符合异位词
     * 2. 先遍历一遍 s 字符串，使用长度为 26 的数组模拟哈希表存储每个字母出现的次数
     * 3. 再遍历一遍 t 字符串，数组中每个字母，每出现一次，对应的位置减一
     * 4. 遍历哈希数组，如果元素全部为 0，则说明 s 和 t 是有效的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            temp[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }
}