package array;

/**
 * @author think
 * @version v 1.0 2020/6/27 20:58
 */
public class FirstMissingPositive41 {
    //41. 缺失的第一个正数
    //给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
    //
    //
    //
    //示例 1:
    //
    //输入: [1,2,0]
    //输出: 3
    //示例 2:
    //
    //输入: [3,4,-1,1]
    //输出: 2
    //示例 3:
    //
    //输入: [7,8,9,11,12]
    //输出: 1
    //https://leetcode-cn.com/problems/first-missing-positive/
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        //3,4,-1,1
        //-1,4,3,1
        //-1,1,3,4
        // nums[nums[i] - 1] != nums[i]
        // nums[nums[1]-1]!=nums[1] nums[3]!=nums[1](4!=1)
        // nums[0]!=nums[1](-1!=1)
        new FirstMissingPositive41().firstMissingPositive(arr);
        //for (int i : arr) {
        //    System.out.print(i+"\t");
        //}
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        //缺失的正数最小为1最大为nums.length+1
        //如果nums[i]在[1,nums.length]的范围内,需要严格保证nums[i] = i+1
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
