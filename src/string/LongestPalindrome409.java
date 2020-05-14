package string;

/**
 * @author think
 * @version v 1.0 2020/5/12 23:40
 */
public class LongestPalindrome409 {
    //409. 最长回文串
    //给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
    //
    //在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
    //
    //注意:
    //假设字符串的长度不会超过 1010。
    //
    //示例 1:
    //
    //输入:
    //        "abccccdd"
    //
    //输出:
    //        7
    //
    //解释:
    //我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
    //https://leetcode-cn.com/problems/longest-palindrome/
    public int longestPalindrome(String s) {
        if(s.length()<=1){
            return s.length();
        }
        char[] chars = s.toCharArray();
        int[] dict = new int[128];
        for (int i = 0; i < chars.length; i++) {
            dict[chars[i]]+=1;
        }
        int res = 0;
        for (int i = 0; i < dict.length; i++) {
            res += dict[i]/2 * 2;
            if(dict[i]%2==1 && res%2==0){
                res+=1;
            }
        }
        return res;
    }
}
