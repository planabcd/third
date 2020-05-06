package dp;

import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/12/5 4:44
 */
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int rows = triangle.size();
        int[] dp = new int[rows+1];
        for(int i=rows-1; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int rows = triangle.size();
        int[] dp = new int[rows];
        List<Integer> lastRows = triangle.get(rows - 1);
        for (int i = 0; i < rows; i++) {
            dp[i] = lastRows.get(i);
        }
        for(int i=rows-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
