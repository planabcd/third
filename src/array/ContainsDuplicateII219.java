package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2020/6/17 22:21
 */
public class ContainsDuplicateII219 {
    //219. 存在重复元素 II
    //给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,2,3,1], k = 3
    //输出: true
    //示例 2:
    //
    //输入: nums = [1,0,1,1], k = 1
    //输出: true
    //示例 3:
    //
    //输入: nums = [1,2,3,1,2,3], k = 2
    //输出: false
    //https://leetcode-cn.com/problems/contains-duplicate-ii/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<=1){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer mapIndex = map.get(nums[i]);
            if(mapIndex!=null){
                if(i-mapIndex<=k){
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
