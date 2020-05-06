package dp;

/**
 * @author think
 * @version v 1.0 2019/12/3 23:14
 */
public class UniquePathsII63 {
    public static void main(String[] args) {
        //int[][] obstacleGrid = {
        //        {0,0,0},
        //        {0,1,0},
        //        {0,0,0}};
        //int[][] obstacleGrid = {
        //        {1}};
        int[][] obstacleGrid = {
                {0,0},
                {1,1},
                {0,0}};
        int res = new UniquePathsII63().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[rows-1][cols-1]==1){
            //终点不可达
            return 0;
        }
        int[] dp = new int[cols];
        dp[cols-1] = 1;
        for(int i=cols-2; i>=0; i--){
            if(obstacleGrid[rows-1][i]!=1){
                dp[i] = dp[i+1];
            }
        }
        for(int i=rows-2; i>=0; i--){
            if(obstacleGrid[i][cols-1]==1){
                dp[cols-1] = 0;
            }
            for(int j=cols-2; j>=0; j--){
                if(obstacleGrid[i][j]!=1){
                    dp[j] = dp[j] +dp[j+1];
                }else{
                    dp[j] = 0;
                }
            }
        }
        return dp[0];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[rows-1][cols-1]==1){
            //终点不可达
            return 0;
        }
        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = 1;
        for(int i=rows-2; i>=0; i--){
            if(obstacleGrid[i][cols-1]!=1){
                dp[i][cols-1] = dp[i+1][cols-1];
            }
        }
        for(int i=cols-2; i>=0; i--){
            if(obstacleGrid[rows-1][i]!=1){
                dp[rows-1][i] = dp[rows-1][i+1];
            }
        }
        for(int i=rows-2; i>=0; i--){
            for(int j=cols-2; j>=0; j--){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

}
