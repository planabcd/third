package array;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2019/9/18 23:32
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int i = new ThreeSumClosest().threeSumClosest(new int[]{1, 1, 1, 0}, 100);
        System.out.println(i);
    }
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        int dest = Integer.MAX_VALUE;
        for(int k=0;k!=nums.length-2;k++){
            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int i=k+1;
            int j=nums.length-1;
            while(i<j){
                int sum = nums[k]+nums[i]+nums[j];
                int newDest = Math.abs(sum-target);
                if(newDest==0){
                    return sum;
                }
                if(newDest<dest){
                    dest = newDest;
                    result = sum;
                }
                if(sum>target){
                    j--;
                }else{
                    i++;
                }
            }
        }
        return result;
    }
}
