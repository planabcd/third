package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/7/26 0:42
 */
public class CourseSchedule207 {
    //207. 课程表
    //你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
    //
    //在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
    //
    //给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
    //
    //
    //
    //示例 1:
    //
    //输入: 2, [[1,0]]
    //输出: true
    //解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
    //示例 2:
    //
    //输入: 2, [[1,0],[0,1]]
    //输出: false
    //解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
    //https://leetcode-cn.com/problems/course-schedule/
    public static void main(String[] args) {
        boolean b = new CourseSchedule207().canFinish(2, new int[][]{{1, 0}});
        System.out.println(b);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //从入度为0的课程开始删除，然后如果入度为0的课程出队,对应的所有后继课程的入度减一,如果后继课程的入度减少到0,也加入到队列中
        //记录每个节点的入度
        int[] in = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            in[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);   
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if(in[i]==0){
                //入度为0的先入队
                queue.offer(i);
            }
        }
        int res = numCourses;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            res--;
            List<Integer> nexts = graph.get(poll);
            for (int i = 0; i < nexts.size(); i++) {
                in[nexts.get(i)]--;
                if(in[nexts.get(i)]==0){
                    queue.offer(nexts.get(i));
                }
            }
        }
        return res==0;
    }
}
