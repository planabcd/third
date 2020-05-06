package dp;

/**
 * @author think
 * @version v 1.0 2019/12/1 16:29
 */
@SuppressWarnings("all")
public class BestTimeToBuyAndSellStockIV188 {
    public static void main(String[] args) {
        //int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices = {1,2};
        int k = 1;
        int i = new BestTimeToBuyAndSellStockIV188().maxProfit(1,prices);
        System.out.println(i);
    }
    //最多两笔交易,最多持有一个股票
    public int maxProfit(int k, int[] prices) {
        if(prices.length<=1 || k==0){
            return 0;
        }
        if(k>prices.length/2){
            return longKMaxProfit(prices);
        }
        //第i天 至多进行了k笔交易 持有/不持有股票的最大收益
        int[][][] dp = new int[prices.length][k+1][2];
        int max = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=1; j<=k; j++){
                if(i==0){
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][k][0];
    }

    public int longKMaxProfit(int[] prices){
        //k特别大的情况下的优化
        int res = 0;
        for(int i=1; i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                res+=prices[i]+prices[i-1];
            }
        }
        return res;
    }
}
