package dp;

/**
 * @author think
 * @version v 1.0 2019/12/7 22:30
 */
public class PerfectSquares279 {
    //dp[i] = Math.min(dp[i-1]+1,dp[i])
    public static void main(String[] args) {
        int res = new PerfectSquares279().numSquares(13);
        System.out.println(res);
    }
    public int numSquares(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = i;
            int k=1;
            while(i-k*k>=0){
                dp[i] = Math.min(dp[i],dp[i-k*k]+1);
                k++;
            }
        }
        return dp[n];
    }
}
