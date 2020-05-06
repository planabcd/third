package bfs;

import java.util.LinkedList;

/**
 * @author think
 * @version v 1.0 2019/12/12 21:52
 */
public class ShortestPathInBinaryMatrix1091 {

    public static void main(String[] args) {
        //int[][] grid = {
        //        {0, 0, 0},
        //        {1, 1, 0},
        //        {1, 1, 0}
        //};
        int[][] grid = {
                {0}
        };
        int res = new ShortestPathInBinaryMatrix1091().shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) {
            return -1;
        }
        if(grid.length==1 && grid[0].length==1){
            return 1;
        }
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        LinkedList<Node> begin = new LinkedList<>();
        boolean[][] used = new boolean[rows][cols];
        used[0][0] = true;
        Node startNode = new Node(0, 0);
        Node endNode = new Node(rows - 1, cols - 1);
        begin.offer(startNode);
        int level = 1;
        while (!begin.isEmpty()) {
            int size = begin.size();
            for (int i = 0; i < size; i++) {
                Node node = begin.poll();
                if (grid[node.x][node.y] != 0) {
                    continue;
                }
                for (int j = 0; j < 8; j++) {
                    int newRow = node.x + dRow[j];
                    int newCol = node.y + dCol[j];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        if (!used[newRow][newCol] && grid[newRow][newCol] != 1) {
                            used[newRow][newCol] = true;
                            if(endNode.x==newRow && endNode.y==newCol){
                                return level + 1;
                            }
                            begin.offer(new Node(newRow, newCol));
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (this.x + "").hashCode() + (this.y + "").hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Node that = (Node) obj;
            return this.x == that.x && this.y == that.y;
        }

    }
}
