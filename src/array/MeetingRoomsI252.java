package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author think
 * @version v 1.0 2020/1/12 22:27
 */
public class MeetingRoomsI252 {
    //给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
    //
    //示例 1:
    //
    //输入: [[0,30],[5,10],[15,20]]
    //输出: false
    //示例 2:
    //
    //输入: [[7,10],[2,4]]
    //输出: true
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/meeting-rooms
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length<=1){
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] prevRow = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curRow = intervals[i];
            if(prevRow[1]<curRow[0]){
                return false;
            }
            prevRow = curRow;
        }
        return true;
    }

}
