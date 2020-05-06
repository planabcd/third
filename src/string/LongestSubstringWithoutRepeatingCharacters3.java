package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2020/1/7 23:41
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    //
    //示例 1:
    //
    //输入: "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){
            return s.length();
        }
        int result = 1;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(map.get(c)!=null){
                start = Math.max(map.get(c)+1,start);
            }
            map.put(c,i);
            result = Math.max(i-start+1,result);
        }
        return result;
    }


    public int lengthOfLongestSubstring2(String s) {
        if(s.length()<=1){
            return s.length();
        }
        //存储每个字符最后出现的位置
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0;
        //pwwkew
        //p->0,w->1,start = Min(1+1,start)
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
               start = Math.max(start,map.get(chars[i])+1);
            }
            map.put(chars[i],i);
            res = Math.max(res,i-start+1);
        }
        return res;
    }
}
