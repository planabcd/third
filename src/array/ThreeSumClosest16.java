package array;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2019/9/18 23:32
 */
public class ThreeSumClosest16 {
    //16. 最接近的三数之和
    //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
    //
    //
    //
    //示例：
    //
    //输入：nums = [-1,2,1,-4], target = 1
    //输出：2
    //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    //
    //
    //提示：
    //
    //        3 <= nums.length <= 10^3
    //        -10^3 <= nums[i] <= 10^3
    //        -10^4 <= target <= 10^4
    //https://leetcode-cn.com/problems/3sum-closest/
    public static void main(String[] args) {
        int i = new ThreeSumClosest16().threeSumClosest(new int[]{1, 1, 1, 0}, 100);
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
