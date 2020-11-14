package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/9/10 0:08
 */
public class CombinationSumII40 {
    //40. 组合总和 II
    //给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的每个数字在每个组合中只能使用一次。
    //
    //说明：
    //
    //所有数字（包括目标数）都是正整数。
    //解集不能包含重复的组合。
    //示例 1:
    //
    //输入: candidates = [10,1,2,7,6,1,5], target = 8,
    //所求解集为:
    //        [
    //        [1, 7],
    //        [1, 2, 5],
    //        [2, 6],
    //        [1, 1, 6]
    //        ]
    //示例 2:
    //
    //输入: candidates = [2,5,2,1,2], target = 5,
    //所求解集为:
    //        [
    //        [1,2,2],
    //        [5]
    //        ]
    //https://leetcode-cn.com/problems/combination-sum-ii/
    public static void main(String[] args) {
        List<List<Integer>> res = new CombinationSumII40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> re : res) {
            System.out.println();
            for (Integer integer : re) {
                System.out.print(integer + "\t");
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return res;
        }
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> temp, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //start必须是在小于candidates的情况下才会判断
            if (candidates[start] > target) {
                break;
            }
            //针对等值的场景,比如 1,1,6是需要记录下来的,所以第一个数字需要记录
            //candidates[i] == candidates[i - 1]可以忽略掉当前值和前一个值相等的情况,但是无法选取比如1,1,5这样的选择
            // for循环的元素之间是平行的,可以选择忽略第一个出现的元素
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            //从当前元素的下一个元素开始选下一个元素
            helper(candidates, i + 1, target - candidates[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
