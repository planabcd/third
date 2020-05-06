package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/23 21:33
 */
public class Permutations47 {

    public static void main(String[] args) {
        final List<List<Integer>> lists = new Permutations47().permuteUnique(new int[]{3,3,0,3});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List <List<Integer>> res = new ArrayList <List<Integer>>();
        if(nums.length==0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<Integer>(),res,used);
        return res;
    }

    private void helper(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> res, boolean[] used) {
        if(start==nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i !=nums.length; i++) {
            if(!used[i]){
                if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                helper(nums,start+1,temp,res,used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }


}
