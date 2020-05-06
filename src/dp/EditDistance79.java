package dp;

/**
 * @author think
 * @version v 1.0 2020/1/5 15:33
 */
public class EditDistance79 {
    //给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
    //
    //你可以对一个单词进行如下三种操作：
    //
    //插入一个字符
    //        删除一个字符
    //替换一个字符
    //示例 1:
    //
    //输入: word1 = "horse", word2 = "ros"
    //输出: 3
    //解释:
    //horse -> rorse (将 'h' 替换为 'r')
    //rorse -> rose (删除 'r')
    //rose -> ros (删除 'e')
    //示例 2:
    //
    //输入: word1 = "intention", word2 = "execution"
    //输出: 5
    //解释:
    //intention -> inention (删除 't')
    //inention -> enention (将 'i' 替换为 'e')
    //enention -> exention (将 'n' 替换为 'x')
    //exention -> exection (将 'n' 替换为 'c')
    //exection -> execution (插入 'u')
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/edit-distance
    public static void main(String[] args) {
        System.out.println(new EditDistance79().minDistance("intention","execution"));
    }

    public int minDistance(String word1, String word2) {
        if(word1.length()==0){
            return word2.length();
        }
        if(word2.length()==0){
            return word1.length();
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //dp[i][j] word1以i-1结尾,word2以j-1结尾的最小编辑距离
        //dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
        //    r o s
        //h   1 2 3
        //o   2
        //r   2
        //s   3
        //r   4
        for (int row = 0; row <= word1.length(); row++) {
            dp[row][0] = row;
        }
        for (int col = 0; col <= word2.length(); col++) {
            dp[0][col] = col;
        }

        for (int row = 1; row <= word1.length(); row++) {
            for (int col = 1; col <= word2.length(); col++) {
                if(word1.charAt(row-1)==word2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1];
                }else{
                    dp[row][col] = Math.min(Math.min(dp[row-1][col],dp[row][col-1]),dp[row-1][col-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
