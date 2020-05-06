package dp;

/**
 * @author think
 * @version v 1.0 2019/12/1 16:29
 */
@SuppressWarnings("all")
public class BestTimeToBuyAndSellStockIII123 {
    public static void main(String[] args) {
        //int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices = {7,6,4,3,1};
        int i = new BestTimeToBuyAndSellStockIII123().maxProfit(prices);
        System.out.println(i);
    }
    //最多两笔交易,最多持有一个股票
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int in = prices.length; //第0~i-1天
        int jn = 3; //当前交易次数 1~2
        int kn = 2; //当前是否持有股票
        int[][][] dp = new int[in][jn][kn];
        int max = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=1; j<=2; j++){
                if(i==0){
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                //max = Math.max(dp[i][j][0],max);
            }
        }
        return dp[prices.length-1][jn-1][0];
    }
}
