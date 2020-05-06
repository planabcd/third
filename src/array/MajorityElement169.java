package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2019/11/23 22:33
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        int result = new MajorityElement169().majorityElement2(new int[]{8,8,8,7,7});
        System.out.println(result);
    }


    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if(count==null){
                count = 1;
            }else{
                count++;
            }
            if(count>nums.length/2){
                return nums[i];
            }
            map.put(nums[i],count);
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private int helper(int[] nums, int start, int end) {
        if(start==end){
            return nums[start];
        }
        int mid = (end-start)/2 +start;
        int leftNum = helper(nums,start,mid);
        int rightNum = helper(nums,mid+1,end);
        if(leftNum==rightNum){
            return leftNum;
        }
        return count(nums,leftNum,start,end)>count(nums,rightNum,start,end)?leftNum:rightNum;
    }

    private int count(int[] nums, int num,int start,int end) {
        int count = 0;
        for(int i=start; i<=end; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }


}
