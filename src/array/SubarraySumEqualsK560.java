package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2020/1/12 16:25
 */
public class SubarraySumEqualsK560 {
    //给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
    //
    //示例 1 :
    //
    //输入:nums = [1,1,1], k = 2
    //输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
    //说明 :
    //
    //数组的长度为 [1, 20,000]。
    //数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
    public static void main(String[] args) {
        new SubarraySumEqualsK560().subarraySum(new int[]{3,4,7,2,-3,1,4,2},7);
    }

    public int subarraySum(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> sum2Count = new HashMap<>();
        sum2Count.put(0,1);
        //sum[j]-sum[i]=k
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum2Count.get(sum-k)!=null){
                count += sum2Count.get(sum-k);
            }
            Integer oldCount = sum2Count.get(sum);
            sum2Count.put(sum,oldCount==null?1:oldCount+1);
        }
        return count;
    }
}
