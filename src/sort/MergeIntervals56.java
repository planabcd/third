package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/12/14 15:33
 */
@SuppressWarnings("all")
public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new MergeIntervals56().merge(intervals);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
            }
        });
        int[][] res = new int[intervals.length][intervals[0].length];
        int lastIndex = 0;
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res[lastIndex];
            if (last[1] < intervals[i][0]) {
                lastIndex++;
                res[lastIndex][0] = intervals[i][0];
                res[lastIndex][1] = intervals[i][1];
            } else {
                last[1] = Math.max(intervals[i][1],last[1]);
            }
        }
        return Arrays.copyOfRange(res,0,lastIndex+1);
    }
    
    public int[][] merge1(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
            }
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            if (last[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                last[1] = Math.max(intervals[i][1],last[1]);
            }
        }
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            arr[i][0] = res.get(i)[0];
            arr[i][1] = res.get(i)[1];
        }
        return arr;
    }
}
