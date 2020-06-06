package dict;

import java.util.HashSet;
import java.util.Set;

/**
 * @author think
 * @version v 1.0 2020/6/6 16:29
 */
public class LongestConsecutiveSequence128 {
    //128. 最长连续序列
    //给定一个未排序的整数数组，找出最长连续序列的长度。
    //
    //要求算法的时间复杂度为 O(n)。
    //
    //示例:
    //
    //输入: [100, 4, 200, 1, 3, 2]
    //输出: 4
    //解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
    //https://leetcode-cn.com/problems/longest-consecutive-sequence/

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer integer : set) {
            if(set.contains(integer-1)){
                continue;
            }
            int count = 1;
            while(set.contains(integer+1)){
                count++;
                integer++;
            }
            res = Math.max(res,count);
        }
        return res;
    }
}
