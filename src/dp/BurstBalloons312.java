package dp;

/**
 * @author think
 * @version v 1.0 2020/7/19 13:52
 */
public class BurstBalloons312 {
    //312. 戳气球
    //有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
    //
    //现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
    //
    //求所能获得硬币的最大数量。
    //
    //说明:
    //
    //你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
    //        0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
    //示例:
    //
    //输入: [3,1,5,8]
    //输出: 167
    //解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
    //coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
    //https://leetcode-cn.com/problems/burst-balloons/
    public static void main(String[] args) {
        int i = new BurstBalloons312().maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }
    public int maxCoins(int[] nums) {
        int[] points = new int[nums.length+2];
        for (int i = 1; i <=  nums.length; i++) {
            points[i] = nums[i-1];
        }
        points[0] = 1;
        points[points.length-1] = 1;
        //dp[i][j] 表示points(i,j)区间内戳破气球的最大硬币数,答案就是求dp[0][points.length-1];
        //dp[i][j] = dp[i][k]+dp[k][j]+dp[i]*dp[k]*dp[j],假定k是(i,j)区间内最后一个戳破的气球
        //k = [i+1,j-1],i>=j的时候dp[i][j]=0
        //i需要从points.length-2遍历到0,因为dp[points.length-1][points.length-1] = 0
        //j需要从i+1遍历到points.length-1
        int[][] dp = new int[points.length][points.length];
        for (int i = points.length-2; i >=0 ; i--) {
            for (int j = i+1; j <= points.length-1; j++) {
                for (int k = i+1; k <=j-1 ; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]);
                }
            }
        }
        return dp[0][points.length-1];
    }
}
