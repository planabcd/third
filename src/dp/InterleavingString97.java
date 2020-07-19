package dp;

/**
 * @author think
 * @version v 1.0 2020/7/18 10:51
 */
public class InterleavingString97 {
    //97. 交错字符串
    //给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
    //
    //示例 1:
    //
    //输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    //输出: true
    //示例 2:
    //
    //输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    //输出: false
    //https://leetcode-cn.com/problems/interleaving-string/
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        System.out.println(new InterleavingString97().isInterleave(s1, s2, s3));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        //dp[i][j]表示s1[0,i-1]和s[0,j-1]能否组成s3[0,i+j-1]
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if(i>0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1);
                }
                if(j>0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
