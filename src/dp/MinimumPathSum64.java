package dp;

/**
 * @author think
 * @version v 1.0 2020/1/12 15:50
 */
public class MinimumPathSum64 {
    //给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    //说明：每次只能向下或者向右移动一步。
    //
    //示例:
    //
    //输入:
    //        [
    //          [1,3,1],
    //        [1,5,3],
    //        [4,2,1]
    //        ]
    //输出: 7
    //解释: 因为路径 1→3→1→1→1 的总和最小。
    //
    //7,3,1
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/minimum-path-sum
    public int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        //dp[i][j] = grid[i][j]+min(dp[i+1][j],dp[i][j+1])
        int[] dp = new int[cols];
        dp[cols-1] = grid[rows-1][cols-1];
        for (int col = cols-2; col >=0 ; col--) {
            dp[col] = dp[col+1]+grid[rows-1][col];
        }
        for (int row = rows-2; row>=0; row--) {
            dp[cols-1] = grid[row][cols-1]+dp[cols-1];
            for (int col = cols-2; col >=0; col--) {
                dp[col] = Math.min(dp[col],dp[col+1])+grid[row][col];
            }
        }
        return dp[0];
    }
}
