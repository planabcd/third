package dp;

/**
 * @author think
 * @version v 1.0 2019/12/5 23:44
 */
public class MaximumProductSubarray152 {

    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int dpMin = nums[0];
        int dpMax = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = dpMax;
            dpMax = Math.max(Math.max(dpMax*nums[i],dpMin*nums[i]),nums[i]);
            dpMin = Math.min(Math.min(temp*nums[i],dpMin*nums[i]),nums[i]);
            res = Math.max(res,dpMax);
        }
        return res;
    }

    public int maxProduct1(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            dpMax[i] = Math.max(Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
            res = Math.max(res,dpMax[i]);
        }
        return res;
    }
}
