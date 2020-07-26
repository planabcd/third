package string;

/**
 * @author think
 * @version v 1.0 2020/7/27 0:52
 */
public class IsSubsequence392 {
    //392. 判断子序列
    //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    //
    //你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
    //
    //字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
    //
    //示例 1:
    //s = "abc", t = "ahbgdc"
    //
    //返回 true.
    //
    //示例 2:
    //s = "axc", t = "ahbgdc"
    //
    //返回 false.
    //
    //后续挑战 :
    //
    //如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
    //https://leetcode-cn.com/problems/is-subsequence/
    public static void main(String[] args) {
        boolean subsequence = new IsSubsequence392().isSubsequence2("aaaaaa", "bbaaaa");
        System.out.println(subsequence);
    }

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while(tIndex<t.length() && sIndex<s.length()){
            if(s.charAt(sIndex)==t.charAt(tIndex)){
                sIndex++;
                tIndex++;
            }else{
                tIndex++;
            }
        }
        return sIndex==s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        //dp[i][j]=t[i,t.length()-1]中j+'a'字符在t字符串中出现的索引
        //dp[2][0]=3 表示 t[2,t.length-1()]中字符a出现在第四个位置(index=3)
        //dp[i][j] = i,j+'a'==t.charAt(i)
        //dp[i][j] = dp[i+1][j],j+'a'!=t.charAt(i)
        //dp[t.length()][a-z]=-1,表示t[t.length():]不会出现a-z字符
        int[][] dp = new int[t.length()+1][26];
        for (int i = 0; i < 26; i++) {
            dp[t.length()][i] = -1;
        }
        for (int i = t.length()-1; i >=0 ; i--) {
            for (int j = 0; j < 26; j++) {
                if(t.charAt(i)==j+'a'){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        int tIndex = 0;
        //t = abcde, s = ace
        //dp[0][a] = 0
        //dp[2][c] = 2
        //dp[4][e] = 4
        for (int i = 0; i < s.length(); i++) {
            if(dp[tIndex][s.charAt(i)-'a']==-1){
                //在t中从tIndex往后永远也找不到s[i]
                return false;
            }
            tIndex = dp[tIndex][s.charAt(i)-'a']+1;
            //if(dp[])
            //if(t.charAt(tIndex)==)
        }
        return true;
    }

}
