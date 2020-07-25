package dp;

/**
 * @author think
 * @version v 1.0 2020/7/26 0:12
 */
public class LongestIncreasingPathInAMatrix329 {
    //329. 矩阵中的最长递增路径
    //给定一个整数矩阵，找出最长递增路径的长度。
    //
    //对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
    //
    //示例 1:
    //
    //输入: nums =
    //        [
    //        [9,9,4],
    //        [6,6,8],
    //        [2,1,1]
    //        ]
    //输出: 4
    //解释: 最长递增路径为 [1, 2, 6, 9]。
    //示例 2:
    //
    //输入: nums =
    //        [
    //        [3,4,5],
    //        [3,2,6],
    //        [2,2,1]
    //        ]
    //输出: 4
    //解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
    //https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
        //int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int result = new LongestIncreasingPathInAMatrix329().longestIncreasingPath(matrix);
        System.out.println(result);
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;
        int[][] direct = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        //dp[i][j] 表示以matrix[i][j]为起点的最大增长子序列的个数
        //dfs[i][j] 表示以matrix[i][j]为起点的最大增长子序列的个数
        int[][] dp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                ans = Math.max(ans,dfs(matrix,row,col,dp,direct));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] dp, int[][] direct) {
        if(dp[row][col]!=0){
            //已经访问过
            return dp[row][col];
        }
        dp[row][col]++;
        for (int i = 0; i < direct.length; i++) {
            int newRow = row+direct[i][0];
            int newCol = col+direct[i][1];
            if(newRow<0 || newRow>=matrix.length || newCol<0 || newCol>=matrix[0].length || matrix[row][col]>=matrix[newRow][newCol]){
                continue;
            }
            dp[row][col] = Math.max(dp[row][col], dfs(matrix, newRow, newCol, dp, direct)+1);
        }
        return dp[row][col];
    }
}
