package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/1/12 15:19
 */
public class MergeIntervals56 {
    //输入: [[1,4],[4,5]]
    //输出: [[1,5]]
    //解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int[] prevRow = intervals[0];
        res.add(prevRow);
        for (int i = 1; i < intervals.length; i++) {
            int[] curRow = intervals[i];
            if(curRow[0]>prevRow[1]){
                //[1,3]  [6,8]-> add[6,8]
                res.add(curRow);
                prevRow = curRow;
            }else{
                //[1,3] [2,4]->[1,max(3,4)]
                prevRow[1] = Math.max(prevRow[1],curRow[1]);
            }
        }
        int[][] resArray = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
