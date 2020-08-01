package window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/8/1 12:03
 */
public class SmallestRangeCoveringElementsFromKLists632 {
    //632. 最小区间
    //你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
    //
    //我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
    //
    //示例 1:
    //
    //输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
    //输出: [20,24]
    //解释:
    //列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
    //列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
    //列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
    //注意:
    //
    //给定的列表可能包含重复元素，所以在这里升序表示 >= 。
    //        1 <= k <= 3500
    //        -105 <= 元素的值 <= 105
    //对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
    //https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(4,10,15,24,26);
        List<Integer> list2 = Arrays.asList(0,9,12,20);
        List<Integer> list3 = Arrays.asList(5,18,22,30);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        int[] ints = new SmallestRangeCoveringElementsFromKLists632().smallestRange(list);
        System.out.println(ints[0]+","+ints[1]);
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int N = 0;
        for (List<Integer> num1 : nums) {
            N += num1.size();
        }
        int[][] order = new int[N][2];
        int numIndex = 0;
        int groupIndex = 0;
        for (List<Integer> num1 : nums) {
            for (Integer num : num1) {
                order[numIndex][0] = num;
                order[numIndex][1] = groupIndex;
                numIndex++;
            }
            groupIndex++;
        }
        //order[0]升序排列
        Arrays.sort(order, (o1, o2) -> o1[0]-o2[0]);
        //先处理成 (num,group),(num,group)的数组格式,num升序排列,滑动窗口里的内容是group,先固定左边,直到右边把所有的group都包含以后,再缩减左边
        int left = 0;
        int right = 0;
        int[] groupCountArray = new int[ nums.size()];
        int groupCount = 0;
        //0,1,1,2,0,窗口需要包含0,1,2以后才能考虑缩减
        int[] ans = new int[2];
        while(right<N){
            if(groupCountArray[order[right][1]]==0){
                //在滑动窗口[left,right]范围内每次拉到一个新人就+1
                groupCount++;
            }
            groupCountArray[order[right][1]]++;
            right++;
            while(groupCount==nums.size()){
                //已经符合条件,可以考虑缩减窗口
                if((ans[0]==0 && ans[1]==0) ||order[right-1][0]-order[left][0]<ans[1]-ans[0]){
                    ans[0] = order[left][0];
                    ans[1] = order[right-1][0];
                }
                if(groupCountArray[order[left][1]]<=1){
                    groupCount--;
                }
                groupCountArray[order[left][1]]--;
                left++;
            }
        }
        return ans;
    }
}
