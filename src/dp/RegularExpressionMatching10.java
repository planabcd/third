package dp;

/**
 * @author think
 * @version v 1.0 2020/6/22 2:27
 */
public class RegularExpressionMatching10 {
//    10. 正则表达式匹配
//    给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//            '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
//    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//    说明:
//
//    s 可能为空，且只包含从 a-z 的小写字母。
//    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
//    示例 1:
//
//    输入:
//    s = "aa"
//    p = "a"
//    输出: false
//    解释: "a" 无法匹配 "aa" 整个字符串。
//    示例 2:
//
//    输入:
//    s = "aa"
//    p = "a*"
//    输出: true
//    解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//    示例 3:
//
//    输入:
//    s = "ab"
//    p = ".*"
//    输出: true
//    解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//    示例 4:
//
//    输入:
//    s = "aab"
//    p = "c*a*b"
//    输出: true
//    解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//    示例 5:
//
//    输入:
//    s = "mississippi"
//    p = "mis*is*p*."
//    输出: false
//    https://leetcode-cn.com/problems/regular-expression-matching/
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //dp[i][j]=true表是s的第i个字符为结尾和p的第j个字符为结尾可以匹配上
        //1.如果p[j-1]==*
        //1.1 p[j-2:j-1]可以使用一次或者多次,比如s=xxxaa,p=xxxa*,
        //1.2 p[j-2:j-1]一次也不可用
        //2.如果p[j-1]!=*
        boolean[][] dp = new boolean[m+1][n+1];
        //s和p都是空字符串,可以匹配上
        dp[0][0] = true;
        for (int i = 0; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    //如果p[j-1]是*,需要看p[j-2]是不是和s[i-1]匹配
                    if(isSameChar(s,p,i,j-1)){
                        //1.1 不需要s[i-1]这个字符,p[0:j-1]依然可以匹配
                        //boolean f1 = dp[i][j] = dp[i-1][j];
                        //1.2 p[j-1:j]没起作用
                        //boolean f2 = dp[i][j] = dp[i][j - 2];
                        dp[i][j] = dp[i-1][j] ||  dp[i][j - 2];
                    }else{
                        //如果说dp[j-2]!=s[i-1],比如s=xxxa,p=xxxb*,则p[j-2][j-1]可以直接被忽略
                        dp[i][j] = dp[i][j-2];
                    }
                }else{
                    if(isSameChar(s,p,i,j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean isSameChar(String s, String p, int i, int j) {
        //如果p[0]=*则数组会越界,不过p="*xx"不是合法的正则输入,可以忽略
        if(i==0){
            return false;
        }
        if(s.charAt(i-1)==p.charAt(j-1)){
            return true;
        }
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return false;
    }

}
