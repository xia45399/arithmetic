package arithmetic.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */
public class Problem3 {

    // TODO: 2018/8/25 优化
    public static void main(String[] args) {
//        System.out.println(new Problem3().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new Problem3().lengthOfLongestSubstring("bbbbb"));
//        System.out.println(new Problem3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Problem3().lengthOfLongestSubstring("abcbdef"));
    }


    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        //以一个字母为起点，开始往右找，不重复字符串
        // 下次循环从上次首个重复的字母所在的下一个开始
        for (int i = 0; i < len; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < len; j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    max = Math.max(max, j - i);
                    i = map.get(c);
                    break;
                } else {
                    if (j == len - 1) {
                        //j到了最后都没重复，那以后找到都不如现在大了
                        max = Math.max(max, len - i);
                        return max;
                    }
                    map.put(c, j);
                }
            }
        }
        return max;
    }
}
