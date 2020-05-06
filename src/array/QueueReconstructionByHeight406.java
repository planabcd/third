package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/1/13 0:55
 */
public class QueueReconstructionByHeight406 {
    //假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
    //
    //注意：
    //总人数少于1100人。
    //
    //示例
    //
    //输入:
    //        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    //
    //输出:
    //        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    //在真实的面试中遇到过这道题？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
    public int[][] reconstructQueue(int[][] people) {
        if(people.length<=1){
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        //先按照身高降序,然后同身高的按照K升序
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1],people[i]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
