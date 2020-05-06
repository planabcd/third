package dp;

/**
 * @author think
 * @version v 1.0 2019/12/6 0:17
 */
public class HouseRobber213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int rob = new HouseRobber213().rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] a1 = new int[nums.length-1];
        int[] a2 = new int[nums.length-1];
        System.arraycopy(nums,0,a1,0,nums.length-1);
        System.arraycopy(nums,1,a1,0,nums.length-1);
        return Math.max(helper(a1),helper(a2));
    }

    public int helper(int[] nums){
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
}
