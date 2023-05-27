package com.jiuxiao.hash.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 悟道九霄
 * @Date 2023/5/27 16:46
 * @Description 205. 同构字符串
 */
public class IsIsomorphic_205 {

    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     * <p>
     * 示例 1:
     * 输入：s = "egg", t = "add"
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：s = "foo", t = "bar"
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：s = "paper", t = "title"
     * 输出：true
     * <p>
     * 提示：
     * 1 <= s.length <= 5 * 10^4
     * t.length == s.length
     * s 和 t 由任意有效的 ASCII 字符组成
     * <p>
     * 思路：
     * 1. 使用一个 map 来记录字符串 s 到字符串 t 的字符映射关系
     * 2. 如果当前 s 中的字符不存在 map 的 key 中，但是却存在于 map 的 value 中，说明当前字符的映射关系 s 有但是 t 没有，不合规矩
     * 3. 如果当前 s 中的字符在 map 的 key 中，那就将当前的 value 与 t 当前字符比较，若不相同则说明映射失败
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if (!map.containsKey(tempS)) {
                if (map.containsValue(tempT)) {
                    return false;
                }
                map.put(tempS, tempT);
            } else {
                if (map.get(tempS) != tempT) {
                    return false;
                }
            }
        }
        return true;
    }
}
