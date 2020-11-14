package dp;

/**
 * @author think
 * @version v 1.0 2020/10/11 10:26
 */
public class PartitionEqualSubsetSum416 {
    //416. 分割等和子集
    //给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    //
    //注意:
    //
    //每个数组中的元素不会超过 100
    //数组的大小不会超过 200
    //示例 1:
    //
    //输入: [1, 5, 11, 5]
    //
    //输出: true
    //
    //解释: 数组可以分割成 [1, 5, 5] 和 [11].
    //
    //
    //示例 2:
    //
    //输入: [1, 2, 3, 5]
    //
    //输出: false
    //
    //解释: 数组不能分割成两个元素和相等的子集
    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum416().canPartition(new int[]{1,5,11,5}));
        System.out.println(new PartitionEqualSubsetSum416().canPartition(new int[]{1,2,3,5}));
    }

    public boolean canPartition(int[] nums) {
        if(nums.length==0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){
            //和为奇数,肯定不满足条件
            return false;
        }
        int target = sum/2;
        //dp[i][j] = 表示nums[0,i]内选择1到n个数是否加起来等于j
        //dp[nums.length-1][target]就是最终答案
        boolean[] dp = new boolean[target+1];
        if(nums[0]<=target){
            dp[nums[0]] = true;
        }
        //dp[i][j] = dp[i-1][j-nums[i]]这种情况下如果j==nums[i]会依赖dp[i][0]的状态,所以默认为true
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            //倒推,一方面可以剪纸,去掉j<nums[i]的填表,另一方面dp[i][j] 依赖dp[i-1][j]以及dp[i-1][0...j-1]的值,倒着填可以保证不会覆盖上一层的结果
            for (int j = target; j >=nums[i]; j--) {
               if(nums[i]==target){
                   //说明nums[i]一个数就可以对半分
                   return true;
               }
                //nums[i]不选 dp[i][j] = dp[i-1][j]
                //nums[i]选择的情况下 dp[i-1][j] || dp[i-1][j-nums[i]]
                //dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
               dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public boolean canPartition2(int[] nums) {
        if(nums.length==0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){
            //和为奇数,肯定不满足条件
            return false;
        }
        int target = sum/2;
        //dp[i][j] = 表示nums[0,i]内选择1到n个数是否加起来等于j
        //dp[nums.length-1][target]就是最终答案
        boolean[][] dp = new boolean[nums.length][target+1];
        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }
        //dp[i][j] = dp[i-1][j-nums[i]]这种情况下如果j==nums[i]会依赖dp[i][0]的状态,所以默认为true
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = true;
            for (int j = 0; j <= target; j++) {
                if(nums[i]==target){
                    //说明nums[i]一个数就可以对半分
                    return true;
                }
                if(j>=nums[i]){
                    //nums[i]不选 dp[i][j] = dp[i-1][j]
                    //nums[i]选择的情况下 dp[i-1][j] || dp[i-1][j-nums[i]]
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
