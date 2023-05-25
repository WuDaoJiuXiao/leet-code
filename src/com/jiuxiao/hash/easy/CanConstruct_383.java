package com.jiuxiao.hash.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 悟道九霄
 * @Date 2023/5/25 19:37
 * @Description 383. 赎金信
 */
public class CanConstruct_383 {

    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * <p>
     * 示例 1：
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     * <p>
     * 示例 2：
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：ransomNote = "aa", magazine = "aab"
     * 输出：true
     * <p>
     * 提示：
     * 1 <= ransomNote.length, magazine.length <= 10^5
     * ransomNote 和 magazine 由小写英文字母组成
     * <p>
     * 思路一：
     * 1. 使用两个 Map 分别统计俩个字符串中每个元素出现的数量
     * 2. 遍历第一个 map，如果每个 key 均在第二个 map 中出现，并且出现次数大于等于第一个，那么就是符合的情况
     * <p>
     * 思路二：
     * 1. 任然是使用 hash 的思想，不过只使用一个长度为 26 的数组来进行统计
     * 2. 首先统计第一个字符串每个字符出现的次数
     * 3. 然后遍历第二个字符串，并将当前字符对应的 hash 数组的值减一
     * 4. 当第二个字符串遍历结束之后，只要 hash 数组所有值均小于等于 0，就说明是符合条件的情况
     */
    // 两个 Map 解法
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 1 && magazine.length() == 1) {
            return ransomNote.equals(magazine);
        }
        Map<Character, Integer> mapNote = new HashMap<>();
        Map<Character, Integer> MapMagize = new HashMap<>();
        //统计第一个字符串
        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            if (mapNote.containsKey(temp)) {
                mapNote.put(temp, mapNote.get(temp) + 1);
            } else {
                mapNote.put(temp, 1);
            }
        }
        //统计第二个字符串
        for (int i = 0; i < magazine.length(); i++) {
            char temp = magazine.charAt(i);
            if (MapMagize.containsKey(temp)) {
                MapMagize.put(temp, MapMagize.get(temp) + 1);
            } else {
                MapMagize.put(temp, 1);
            }
        }
        //只要第一个 map 的 key 均在第二个 map 中出现，且出现次数均小于第二个，则就是可以构成
        for (Map.Entry<Character, Integer> entry : mapNote.entrySet()) {
            char tempKey = entry.getKey();
            if (!MapMagize.containsKey(tempKey)) {
                return false;
            } else {
                if (MapMagize.get(tempKey) < mapNote.get(tempKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 一个 hash 数组解法
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() == 1 && magazine.length() == 1) {
            return ransomNote.equals(magazine);
        }
        int[] helper = new int[26];
        for (char c1 : ransomNote.toCharArray()) {
            helper[c1 - 'a']++;
        }
        for (char c2 : magazine.toCharArray()) {
            helper[c2 - 'a']--;
        }
        for (int num : helper) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
