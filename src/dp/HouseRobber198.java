package dp;

/**
 * @author think
 * @version v 1.0 2019/12/5 21:54
 */
public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int res = new HouseRobber198().rob(nums);
        System.out.println(res);
    }

    public int rob1(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0],nums[1]);
        int res = cur;
        for(int i=2; i<nums.length; i++){
            int temp = cur;
            cur = Math.max(cur,pre+nums[i]);
            res = Math.max(cur,res);
            pre = temp;
        }
        return res;
    }

    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int num : nums) {
            int temp = cur;
            cur = Math.max(pre+num,cur);
            pre = temp;
        }
        return cur;
    }

    public int rob2(int[] nums) {
        //a[i] //如果第i个房子必偷窃的最大价值
        //a[i] = Math.max(a[i-1],a[i-2]+nums[i])
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int res = 0;
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            res = Math.max(dp[i],res);
        }
        return res;
    }

    public int rob3(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //a[i][0] = a[i-1][1]+nums[i] 第i个房子偷窃的最大值
        //a[i][1] = a[i-1][0]+a[i-1][1] 第i个房子不偷窃的最大值
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for(int i=1; i!=nums.length; i++){
            dp[i][0] = dp[i-1][1]+nums[i];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
