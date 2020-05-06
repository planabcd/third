package dp;

/**
 * @author think
 * @version v 1.0 2019/12/8 18:26
 */
public class PalindromicSubstring647 {
    //给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
    //
    //具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
    //
    //示例 1:
    //
    //输入: "abc"
    //输出: 3
    //解释: 三个回文子串: "a", "b", "c".
    //示例 2:
    //
    //输入: "aaa"
    //输出: 6
    //说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/palindromic-substrings
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstring647().countSubstrings("abc"));
        System.out.println(new PalindromicSubstring647().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        if(s.length()<=1){
            return s.length();
        }
        //dp[start][end] = true 表示start->end为回文字符串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int end = 1; end < s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if(s.charAt(start)==s.charAt(end) && (end-start<=2 || dp[start+1][end-1])){
                    dp[start][end] = true;
                    result++;
                }
            }
        }
        return result+s.length();
    }
}
