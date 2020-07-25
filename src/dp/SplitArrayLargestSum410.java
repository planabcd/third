package dp;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2020/7/25 16:24
 */
public class SplitArrayLargestSum410 {
    //410. 分割数组的最大值
    //给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
    //
    //注意:
    //数组长度 n 满足以下条件:
    //
    //        1 ≤ n ≤ 1000
    //        1 ≤ m ≤ min(50, n)
    //示例:
    //
    //输入:
    //nums = [7,2,5,10,8]
    //m = 2
    //
    //输出:
    //        18
    //
    //解释:
    //一共有四种方法将nums分割为2个子数组。
    //其中最好的方式是将其分为[7,2,5] 和 [10,8]，
    //因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
    //https://leetcode-cn.com/problems/split-array-largest-sum/
    public static void main(String[] args) {
        int i = new SplitArrayLargestSum410().splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        System.out.println(i);
    }
    public int splitArray(int[] nums, int m) {
        //dp[i][j]表示前i个数分成j段各自和的最小值
        //假设前k个数分成j-1段,第k+1个数到第i个数分成了j段
        //dp[i][j] = max(dp[k][j-1],sum(第k+1个数到第i个数的和))
        //k的最小值为0,当k=0时,dp[0][0] =0 ,dp[0][>0]都是不合法的,不可能把0个数分成大于0段
        // 最大值为i-1,至少要保证第j段有一个数
        int[][] dp = new int[nums.length+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            //由于是取最小值,所以初始化为最大
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //sum[i]=前i个数的和
        int[] sum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= nums.length ; i++) {
            //i个数最多分成i段和m段的最小值
            for (int j = 1; j <=Math.min(i,m) ; j++) {
                for (int k = 0; k <= i-1 ; k++) {
                    //sum[i]-sum[k]表示前i个数减去前k个数,即第k+1个数到第i个数的和
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[k][j-1], sum[i]-sum[k]));
                }
            }
        }
        return dp[nums.length][m];
    }
}
