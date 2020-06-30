package dp;

/**
 * @author think
 * @version v 1.0 2020/7/1 1:01
 */
public class MaximumLengthOfRepeatedSubarray718 {
    //718. 最长重复子数组
    //给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
    //
    //示例 1:
    //
    //输入:
    //A: [1,2,3,2,1]
    //B: [3,2,1,4,7]
    //输出: 3
    //解释:
    //长度最长的公共子数组是 [3, 2, 1]。
    //说明:
    //
    //        1 <= len(A), len(B) <= 1000
    //        0 <= A[i], B[i] < 100
    //https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfRepeatedSubarray718().findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    public int findLength(int[] A, int[] B) {
        //dp[i][j] 表示以A[0:i]和B[0:j]的公共子数组长度
        int[][] dp = new int[A.length+1][B.length+1];
        int res = 0;
        for (int i = 1; i < A.length+1; i++) {
            for (int j = 1; j < B.length+1; j++) {
                if(A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }



}
