package binary;

/**
 * @author think
 * @version v 1.0 2019/12/2 23:20
 */
public class SearchInRotaedSortedArray33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {3,1};
        int search = new SearchInRotaedSortedArray33().search(nums2, 1);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<=right){
            mid = (right-left)/2+left;
            if(nums[mid]==target){
                return mid;
            }else if(nums[left]<=nums[mid]){
                //左侧有序
                if(target>=nums[left] && target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
