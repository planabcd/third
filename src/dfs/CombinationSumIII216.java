package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/9/11 22:09
 */
public class CombinationSumIII216 {
    //216. 组合总和 III
    //找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    //
    //说明：
    //
    //所有数字都是正整数。
    //解集不能包含重复的组合。
    //示例 1:
    //
    //输入: k = 3, n = 7
    //输出: [[1,2,4]]
    //示例 2:
    //
    //输入: k = 3, n = 9
    //输出: [[1,2,6], [1,3,5], [2,3,4]]
    //https://leetcode-cn.com/problems/combination-sum-iii/
    public static void main(String[] args) {
        List<List<Integer>> res = new CombinationSumIII216().combinationSum3(3, 15);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, k, n, temp, res);
        return res;
    }

    private void helper(int[] nums, int start, int k, int n, List<Integer> temp, List<List<Integer>> res) {
        if(k==0){
            if(n==0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(n<0){
            return;
        }
        if(start<= 8 && nums[start]>n){
            return;
        }
        for (int i = start; i < 9; i++) {
            if(n-nums[i]<0){
                break;
            }
            temp.add(nums[i]);
            helper(nums, i+1, k-1, n-nums[i], temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
