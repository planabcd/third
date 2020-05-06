package dp;

/**
 * @author think
 * @version v 1.0 2020/1/12 13:01
 */
public class MaximalSquare221 {
    //在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
    //
    //示例:
    //
    //输入:
    //
    //        1 0 1 0 0
    //        1 0 1 1 1
    //        1 1 1 1 1
    //        1 0 0 1 0
    //
    //输出: 4
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximal-square
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 ||matrix[0].length==0){
            return 0;
        }
        //最长的正方形边长,dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
        int rows = matrix.length;
        int cols = matrix[0].length;
        int width = 0;
        int[][] dp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            if(matrix[row][cols-1] =='1'){
                dp[row][cols-1] = 1;
                width = 1;
            }
        }
        for (int col = 0; col < cols; col++) {
            if(matrix[rows-1][col]=='1'){
                dp[rows-1][col] = 1;
                width = 1;
            }
        }
        for (int row = rows-2; row >=0 ; row--) {
            for (int col = cols-2; col >=0 ; col--) {
                if(matrix[row][col]=='1'){
                    dp[row][col] = Math.min(dp[row+1][col+1],Math.min(dp[row+1][col],dp[row][col+1]))+1;
                    width = Math.max(dp[row][col],width);
                }
            }
        }
        return width*width;
    }
}
