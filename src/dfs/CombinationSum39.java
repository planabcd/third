package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liaoxin
 * @version v 1.0 2020/1/31 1:01
 */
public class CombinationSum39 {
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的数字可以无限制重复被选取。
    //
    //说明：
    //
    //所有数字（包括 target）都是正整数。
    //解集不能包含重复的组合。 
    //示例 1:
    //
    //输入: candidates = [2,3,6,7], target = 7,
    //所求解集为:
    //        [
    //        [7],
    //        [2,2,3]
    //        ]
    //示例 2:
    //
    //输入: candidates = [2,3,5], target = 8,
    //所求解集为:
    //        [
    //          [2,2,2,2],
    //          [2,3,3],
    //          [3,5]
    //        ]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/combination-sum

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum39().combinationSum(new int[]{8,7,4,3}, 11);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0 || target == 0) {
            return result;
        }
        //排序以后才可以根据target<candidates[start]来剪枝
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, target, temp, result);
        return result;

    }

    private void helper(int[] candidates, int start, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<candidates[start]){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            temp.add(num);
            helper(candidates, i, target - num, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
