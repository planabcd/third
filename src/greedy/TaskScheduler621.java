package greedy;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2019/12/8 20:12
 */
public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int i = new TaskScheduler621().leastInterval(tasks, n);
        System.out.println(i);
    }

    public int leastInterval(char[] tasks, int n) {
        if(n==0){
            return tasks.length;
        }
        int[] map = new int[26];
        for (char task : tasks) {
            map[task-'A']+=1;
        }
        Arrays.sort(map);
        int maxVal = map[25] - 1;
        int idle = maxVal*n;
        for(int i=24; i>=0; i--){
            idle-=Math.min(maxVal,map[i]);
        }
        return idle>0? idle+tasks.length: tasks.length;
    }
}
