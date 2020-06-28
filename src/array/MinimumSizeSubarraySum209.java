package array;

/**
 * @author think
 * @version v 1.0 2020/6/29 0:12
 */
public class MinimumSizeSubarraySum209 {
    //209. 长度最小的子数组
    //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
    //
    //
    //
    //示例：
    //
    //输入：s = 7, nums = [2,3,1,2,4,3]
    //输出：2
    //解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
    //
    //
    //进阶：
    //
    //如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
    //https://leetcode-cn.com/problems/minimum-size-subarray-sum/
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        //双指针,start和end之间的数加起来要大于等于s
        while (end < nums.length) {
            sum+=nums[end];
            while(sum>=s){
                res = Math.min(res,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }

}
