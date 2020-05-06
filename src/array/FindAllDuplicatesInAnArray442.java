package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/1/18 23:14
 */
public class FindAllDuplicatesInAnArray442 {
    //给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
    //
    //找到所有出现两次的元素。
    //
    //你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
    //
    //示例：
    //
    //输入:
    //        [4,3,2,7,8,2,3,1]
    //
    //输出:
    //        [2,3]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesInAnArray442().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length<=1){
            return res;
        }
        //1<=nums[i]<=n
        //0<=nums[i]-1<=n-1
        //调整数组顺序,nums[i]=i+1
        for (int i = 0; i < nums.length; i++) {
            //最终期望
            //1,2,3,4,5,6,7,8
            //索引
            //0,1,2,3,4,5,6,7
            //原始数组
            //4,3,2,7,8,2,3,1
            //第一步 nums[0]=4!=1,nums[0]和nums[3]交换
            //7,3,2,4,8,2,3,1
            //第二步
            //3,3,2,4,8,2,7,1
            //最终目的 nums[i]= i+1
            while(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                //swap a and b
                //swap 1 and 2
                //a = a+b; //a=3
                //b = a-b; //b=3-2=1
                //a = a-b; //a=3-1=2
                //a = a^b = 01^10 = 11
                //b = a^b = 11^10 = 01
                //a = a^b = 11^01 = 10
                swap(nums,nums[i]-1,i);
                //int temp = nums[nums[i]-1];
                //nums[nums[i]-1] = nums[i];
                //nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
}
