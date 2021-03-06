package dp;

/**
 * @author think
 * @version v 1.0 2020/7/30 0:29
 */
public class IntegerBreak343 {
    //343. 整数拆分
    //给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
    //
    //示例 1:
    //
    //输入: 2
    //输出: 1
    //解释: 2 = 1 + 1, 1 × 1 = 1。
    //示例 2:
    //
    //输入: 10
    //输出: 36
    //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
    //说明: 你可以假设 n 不小于 2 且不大于 58。
    //https://leetcode-cn.com/problems/integer-break/
    public int integerBreak(int n) {
        //dp[i]表示和为i的数的最大乘
        //假i可拆解为j和i-j的和
        //假定j不可拆,i-j如果也不可拆,dp[i] = j*(i-j)
        //如果i-j可拆,dp[i] = j*dp[i-j],j的取值为1到i-1
        int[] dp = new int[n+1];
        //dp[0] = dp[1] = 0,0和1都不可以拆
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i-1 ; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
