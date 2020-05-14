package dfs;

/**
 * @author think
 * @version v 1.0 2020/5/14 23:15
 */
public class MaxAreaOfIsland695 {
    //695. 岛屿的最大面积
    //给定一个包含了一些 0 和 1 的非空二维数组 grid 。
    //
    //一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
    //
    //找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
    //
    //
    //
    //示例 1:
    //
    //        [[0,0,1,0,0,0,0,1,0,0,0,0,0],
    //        [0,0,0,0,0,0,0,1,1,1,0,0,0],
    //        [0,1,1,0,1,0,0,0,0,0,0,0,0],
    //        [0,1,0,0,1,1,0,0,1,0,1,0,0],
    //        [0,1,0,0,1,1,0,0,1,1,1,0,0],
    //        [0,0,0,0,0,0,0,0,0,0,1,0,0],
    //        [0,0,0,0,0,0,0,1,1,1,0,0,0],
    //        [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    //对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
    //
    //示例 2:
    //
    //        [[0,0,0,0,0,0,0,0]]
    //对于上面这个给定的矩阵, 返回 0。
    //
    //
    //
    //注意: 给定的矩阵grid 的长度和宽度都不超过 50。
    //https://leetcode-cn.com/problems/max-area-of-island/

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland695().maxAreaOfIsland(grid));

    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(grid[row][col]==1){
                    result = Math.max(result,dfs(grid,row,col));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int row, int col) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0){
            return 0;
        }
        grid[row][col] = 0;
        return 1+dfs(grid,row+1,col)+dfs(grid,row-1,col)+dfs(grid, row, col+1)+dfs(grid, row, col-1);
    }


}
