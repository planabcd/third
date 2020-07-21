package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2020/7/20 0:43
 */
public class TwoSumIIInputArrayIsSorted167 {
    //167. 两数之和 II - 输入有序数组
    //给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    //
    //函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    //
    //说明:
    //
    //返回的下标值（index1 和 index2）不是从零开始的。
    //你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
    //示例:
    //
    //输入: numbers = [2, 7, 11, 15], target = 9
    //输出: [1,2]
    //解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
    //https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
    public static void main(String[] args) {
        int[] ints = new TwoSumIIInputArrayIsSorted167().twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum==target){
                return new int[]{i+1, j+1};
            }
            if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{};
    }
        public int[] twoSum2(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i+1};
            }
            map.put(numbers[i],i+1);
        }
        return new int[]{};
    }


}
