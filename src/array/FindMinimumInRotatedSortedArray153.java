package array;

/**
 * @author think
 * @version v 1.0 2019/12/19 23:08
 */
public class FindMinimumInRotatedSortedArray153 {

    public int findMin(int[] nums) {
        // 4 5 6 7 1 2 3
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        //顺序数组
        if(nums[0]<=nums[nums.length-1]){
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid = (end-start)/2+start;
            if(nums[mid]>=nums[mid+1]){
                return nums[mid+1];
            }
            if(mid>0 && nums[mid-1]>=nums[mid]){
                return nums[mid];
            }
            if(nums[mid]>nums[0]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
