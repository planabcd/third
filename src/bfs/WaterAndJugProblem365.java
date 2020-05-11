package bfs;

import java.util.*;

/**
 * @author think
 * @version v 1.0 2020/5/11 23:57
 */
public class WaterAndJugProblem365 {
    //365. 水壶问题
    //有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
    //
    //如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
    //
    //你允许：
    //
    //装满任意一个水壶
    //        清空任意一个水壶
    //从一个水壶向另外一个水壶倒水，直到装满或者倒空
    //示例 1: (From the famous "Die Hard" example)
    //
    //输入: x = 3, y = 5, z = 4
    //输出: True
    //示例 2:
    //
    //输入: x = 2, y = 6, z = 5
    //输出: False
    //https://leetcode-cn.com/problems/water-and-jug-problem/


    //
    public static void main(String[] args) {
        //System.out.println(new Pair(1,2).equals(new Pair(1,2)));
        System.out.println(new WaterAndJugProblem365().canMeasureWater(2,6,5));
        System.out.println(new WaterAndJugProblem365().canMeasureWater(3,5,4));
        System.out.println(new Pair(0,1).hashCode());
        System.out.println(new Pair(1,2).hashCode());
        //HashSet<Pair> pairs = new HashSet<>();
        //pairs.add(new Pair(1,2));
        //System.out.println( pairs.contains(new Pair(1,2)));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if(z==0){
            return true;
        }
        if (x + y < z) {
            return false;
        }
        if(x==z || y==z || x+y==z){
            return true;
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        Set<Pair> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (poll.getX() == z || poll.getY() == z || poll.getX() + poll.getY() == z) {
                return true;
            }
            visited.add(poll);
            List<Pair> pairs = getNextPairs(poll,x,y);
            for (Pair pair : pairs) {
                if (!visited.contains(pair)) {
                    queue.offer(pair);
                }
            }
        }
        return false;
    }

    private List<Pair> getNextPairs(Pair poll, int maxX, int maxY) {
        List<Pair> pairs = new ArrayList<>();
        int cx = poll.getX();
        int cy = poll.getY();
        //加水
        if(cx<maxX){
            pairs.add(new Pair(maxX,cy));
        }
        if(cy<maxY){
            pairs.add(new Pair(cx,maxY));
        }
        //清空
        if(cx>0){
            pairs.add(new Pair(0,cy));
        }
        if(cy>0){
            pairs.add(new Pair(cx,0));
        }
        //A不空B不空,A倒入B,A还剩空间
        if(cx-(maxY-cy)>0){
            pairs.add(new Pair(cx-(maxY-cy),maxY));
        }
        //A不空B不空,B倒入A,B还剩空间
        if(cy-(maxX-cx)>0){
            pairs.add(new Pair(maxX,cy-(maxX-cx)));
        }
        //A不空B不空,A倒入B,A全空,B不满
        if(cx+cy<maxX){
            pairs.add(new Pair(cx+cy,0));
        }
        //A不空B不空,B倒入A,B全空,A不满
        if(cx+cy<maxY){
            pairs.add(new Pair(0, cx+cy));
        }
        return pairs;
    }


    static class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int hashCode() {
            return (x+","+y).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Pair that = (Pair) obj;
            return that.x == this.x && that.y == this.y;
        }

    }
}
