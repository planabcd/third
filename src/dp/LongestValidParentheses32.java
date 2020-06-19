package dp;

/**
 * @author think
 * @version v 1.0 2020/6/16 22:59
 */
public class LongestValidParentheses32 {
    //32. 最长有效括号
    //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    //
    //示例 1:
    //
    //输入: "(()"
    //输出: 2
    //解释: 最长有效括号子串为 "()"
    //示例 2:
    //
    //输入: ")()())"
    //输出: 4
    //解释: 最长有效括号子串为 "()()"
    //https://leetcode-cn.com/problems/longest-valid-parentheses/
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses32().longestValidParentheses(")()())"));
        System.out.println(new LongestValidParentheses32().longestValidParentheses("(()"));
    }


    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        //dp[i] 表示以i结尾的字符串的最长有效括号子串的长度
        int[] dp = new int[s.length()];
        //如果s[i]=='(',则s[i]=0
        //如果s[i]==')',如果s[i-1]=='(',则dp[i] = dp[i-2]+2;
        //如果s[i]==')',如果s[i-1]==')',假设x为s[i-1]对应的'(',则i-1-x+1=dp[i-1],则x = i-dp[i-1]
        // x.......)),x是i-1对应的(,那么x-1就是i对应的(
        // 所以dp[i] = dp[x-2]+dp[i-1]+2 = dp[i-dp[i-1]-2]+dp[i-1]+2
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==')'){
                //dp[i] = dp[i-2]+2;
                if(s.charAt(i-1)=='('){
                    if(i-2>0){
                        dp[i] = dp[i-2]+2;
                    }else{
                        dp[i] = 2;
                    }
                }else{
                    //dp[i] = dp[i-dp[i-1]-2]+dp[i-1]+2
                    if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                        if(i-dp[i-1]-2>0){
                            dp[i] = dp[i-dp[i-1]-2] + dp[i-1]+2;
                        }else{
                            dp[i] = dp[i-1]+2;
                        }
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
