package dp;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2019/12/3 23:14
 */
public class UniquePaths62 {
    public static void main(String[] args) {
        int res = new UniquePaths62().uniquePaths(7, 3);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        int cols = m;
        int rows = n;
        int[] dp = new int[cols];
        Arrays.fill(dp,1);
        for(int i=rows-2; i>=0; i--){
            for(int j=cols-2; j>=0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }

    public int uniquePaths2(int m, int n) {
        //cols = m,rows = n
        int cols = m;
        int rows = n;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(i==rows-1){
                    dp[i][j] = 1;
                }
                if(j==cols-1){
                    dp[i][j] = 1;
                }
            }
        }
        for(int row = rows-2; row>=0; row--){
            for(int col = cols-2;col>=0; col--){
                dp[row][col] = dp[row+1][col]+dp[row][col+1];
            }
        }
        return dp[0][0];
    }
}
