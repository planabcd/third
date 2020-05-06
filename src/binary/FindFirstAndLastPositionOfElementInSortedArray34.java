package binary;

/**
 * @author liaoxin
 * @version v 1.0 2020/1/31 0:45
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //
    //你的算法时间复杂度必须是 O(log n) 级别。
    //
    //如果数组中不存在目标值，返回 [-1, -1]。
    //
    //示例 1:
    //
    //输入: nums = [5,7,7,8,8,10], target = 8
    //输出: [3,4]
    //示例 2:
    //
    //输入: nums = [5,7,7,8,8,10], target = 6
    //输出: [-1,-1]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array

    public static void main(String[] args) {
        int[] result = new FindFirstAndLastPositionOfElementInSortedArray34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }


    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if(nums.length==0){
            return result;
        }
        int leftIndex = find(nums, 0, nums.length - 1, target, true);
        if(leftIndex==-1){
            return result;
        }
        int rightIndex = find(nums, leftIndex, nums.length - 1, target, false);
        result[0] = leftIndex;
        result[1] = rightIndex;
        return result;
    }

    public int find(int[] nums,int start,int end,int target,boolean isLeftLimit){
        while(start<=end){
            int mid = (end-start)/2+start;
            if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                //相等
                if(isLeftLimit){
                    //寻找左边界
                    if(mid==0 || nums[mid-1]!=nums[mid]){
                        return mid;
                    }else{
                        //继续往左搜索
                        end = mid-1;
                    }
                }else{
                    if(mid==nums.length-1 || nums[mid+1]!=nums[mid]){
                        return mid;
                    }else{
                        //继续往右搜索
                        start = mid+1;
                    }
                }
            }
        }
        return -1;
    }

}
