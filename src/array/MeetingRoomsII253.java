package array;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2020/1/12 22:27
 */
public class MeetingRoomsII253 {
    //给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
    //
    //示例 1:
    //
    //输入: [[0, 30],[5, 10],[15, 20]]
    //输出: 2
    //示例 2:
    //
    //输入: [[7,10],[2,4]]
    //输出: 1
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/meeting-rooms-ii
    public int minMeetingRooms(int[][] intervals) {

        //[[0, 30],[5, 10],[15, 20]]
        //0,5,15
        //10,20,30

        int res = 0;
        if(intervals.length<=1){
            return intervals.length;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex = 0;
        int endIndex = 0;
        while(startIndex<start.length){
            if(start[startIndex]>=end[endIndex]){
                //有会议室释放
                res--;
                endIndex++;
            }
            res++;
            startIndex++;
        }
        return res;
    }

}
