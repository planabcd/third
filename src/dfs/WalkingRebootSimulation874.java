package dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author think
 * @version v 1.0 2019/12/1 21:30
 */
public class WalkingRebootSimulation874 {
    public static void main(String[] args) {
        int[] comands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        int res = new WalkingRebootSimulation874().robotSim(comands, obstacles);
        System.out.println(res);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        if(commands.length==0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        if(obstacles.length!=0){
            for (int[] obstacle : obstacles) {
                if(obstacle.length==2){
                    set.add(obstacle[0]+","+obstacle[1]);
                }
            }
        }
        int[][] dest = {
                {0,1,0,-1},
                {1,0,-1,0}
        };
        int d = 0;
        int x = 0;
        int y = 0;
        int res =  0;
        for (int command : commands) {
            if(command==-1){
                d = (d+1)%4;
                continue;
            }else if(command==-2){
                d = (d+3)%4;
                continue;
            }
            for (int i = 0; i <command; i++) {
                int newX = x+dest[0][d];
                int newY = y+dest[1][d];
                if(set.contains(newX+","+newY)){
                    break;
                }
                x = newX;
                y = newY;
                res = Math.max(res,x*x+y*y);
            }
        }
        return res;
    }
}
