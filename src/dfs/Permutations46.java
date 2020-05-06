package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/1/9 0:20
 */
public class Permutations46 {
    //给定一个没有重复数字的序列，返回其所有可能的全排列。
    //
    //示例:
    //
    //输入: [1,2,3]
    //输出:
    //        [
    //        [1,2,3],
    //        [1,3,2],
    //        [2,1,3],
    //        [2,3,1],
    //        [3,1,2],
    //        [3,2,1]
    //        ]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/permutations
    public static void main(String[] args) {
        List<List<Integer>> res = new Permutations46().permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums,used,new ArrayList<Integer>(),res);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i] = true;
                temp.add(nums[i]);
                dfs(nums,used,temp,res);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
