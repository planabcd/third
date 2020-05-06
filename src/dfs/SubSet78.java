package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/23 17:01
 */
public class SubSet78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        final List<List<Integer>> subsets = new SubSet78().subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }

    //给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    //
    //说明：解集不能包含重复的子集。
    //
    //示例:
    //
    //输入: nums = [1,2,3]
    //输出:
    //        [
    //        [3],
    //          [1],
    //          [2],
    //          [1,2,3],
    //          [1,3],
    //          [2,3],
    //          [1,2],
    //          []
    //        ]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/subsets

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(nums.length==0){
            return result;
        }
        //[]
        //[]+1->[],1
        //([],1 )+2->[],1,2,(1,2)
        //[],1,2,(1,2),3,(1,3),(2,3),(1,2,3)
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> oldRow = result.get(j);
                List<Integer> newRow = new ArrayList<>();
                result.add(newRow);
                newRow.addAll(oldRow);
                newRow.add(nums[i]);
            }
        }
        return result;
    }


}
