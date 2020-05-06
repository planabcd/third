package dp;

/**
 * @author think
 * @version v 1.0 2020/1/9 0:29
 */
public class MaximumSubarray53 {
    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //示例:
    //
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-subarray
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //dp[i] 以i结尾连续子数组的最大和
        int cur = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur = cur+nums[i];
            res = Math.max(cur,res);
            if(cur<0){
                cur = 0;
            }
        }
        return res;
    }
}
