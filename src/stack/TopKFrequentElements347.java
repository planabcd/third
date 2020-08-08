package stack;

import java.util.*;

/**
 * @author think
 * @version v 1.0 2020/8/2 9:53
 */
public class TopKFrequentElements347 {
    //347. 前 K 个高频元素
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]
    //示例 2:
    //
    //输入: nums = [1], k = 1
    //输出: [1]
    //
    //
    //提示：
    //
    //你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    //你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
    //题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
    //你可以按任意顺序返回答案。
    //https://leetcode-cn.com/problems/top-k-frequent-elements/
    public static void main(String[] args) {
        int[] result = new TopKFrequentElements347().topKFrequent(new int[]{1}, 1);
        for (int num : result) {
            System.out.print(num+"\t");
        }
        PriorityQueue<Object> objects = new PriorityQueue<>();
        objects.offer(3);
        objects.offer(4);
        objects.offer(5);
        while(!objects.isEmpty()){
            System.out.println(objects.poll());
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length<k){
            return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //以value建立小根堆
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if(index>=k){
                priorityQueue.poll();
            }
            index++;
        }
        int[] result = new int[k];
        int i = 0;
        while(!priorityQueue.isEmpty()){
            result[i++] =priorityQueue.poll().getKey();
        }
        return result;
    }
}
