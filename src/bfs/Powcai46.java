package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/23 20:55
 */
public class Powcai46 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Powcai46().permute(new int[]{1, 2, 3});
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        boolean[] accessed = new boolean[nums.length];
        helper(nums,0,new ArrayList<Integer>(),res,accessed);
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> temp, List<List<Integer>> res, boolean[] accessed) {
        if(nums.length==start){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i !=nums.length ; i++) {
            if(!accessed[i]){
                accessed[i] = true;
                temp.add(nums[i]);
                helper(nums,start+1,temp,res,accessed);
                temp.remove(temp.size()-1);
                accessed[i] = false;

            }
        }
    }
}
