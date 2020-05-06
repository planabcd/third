package string;

/**
 * @author think
 * @version v 1.0 2020/1/5 12:30
 */
public class LongestPalindromicSubstring5 {
    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    //
    //示例 1：
    //
    //输入: "babad"
    //输出: "bab"
    //注意: "aba" 也是一个有效答案。
    //示例 2：
    //
    //输入: "cbbd"
    //输出: "bb"
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/longest-palindromic-substring
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                if(s.charAt(right)==s.charAt(left) && ( right-left<=2 || dp[left+1][right-1])){
                    dp[left][right] = true;
                    int length = right-left+1;
                    if(length>maxLength){
                        maxLength = length;
                        maxStart = left;
                        maxEnd = right;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
}

