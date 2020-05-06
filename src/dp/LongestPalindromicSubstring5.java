package dp;

/**
 * @author think
 * @version v 1.0 2019/12/8 18:26
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
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring5().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubstring5().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        int resultL = 0;
        int resultR = 0;
        for(int r=1; r<s.length(); r++){
            for(int l=0; l<r; l++){
                if(s.charAt(l)==s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l+1>max){
                        resultL = l;
                        resultR = r;
                        max = r-l+1;
                    }
                }
            }
        }
        return s.substring(resultL,resultR+1);
    }
}
