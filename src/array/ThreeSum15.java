package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/12/20 0:21
 */
public class ThreeSum15 {
    //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    //
    //满足要求的三元组集合为：
    //        [
    //        [-1, 0, 1],
    //        [-1, -1, 2]
    //        ]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/3sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        //排序后使用双指针
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0){
                return res;
            }
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int x = i;
            int y = i+1;
            int z = nums.length-1;
            while(y<z){
                int target = nums[x]+nums[y]+nums[z];
                if(target==0){
                    List<Integer> line = new ArrayList<>();
                    res.add(line);
                    line.add(nums[x]);
                    line.add(nums[y]);
                    line.add(nums[z]);
                    while(y+1<z && nums[y]==nums[y+1]){
                        y++;
                    }
                    while(y<z-1 && nums[z]==nums[z-1]){
                        z--;
                    }
                    y++;
                    z--;
                }else if(target>0){
                    z--;
                }else{
                    y++;
                }
            }
        }
        return res;
    }
}
