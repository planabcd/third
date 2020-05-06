package dp;

/**
* @author think
 * @version v 1.0 2019/12/1 16:29
 */
@SuppressWarnings("all")
public class BestTimeToBuyAndSellStockWithCollDown309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        //int[] prices = {1,2};
        int i = new BestTimeToBuyAndSellStockWithCollDown309().maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if(prices.length<=1) {
            return 0;
        }
        if(prices.length==2){
            return Math.max(prices[1]-prices[0],0);
        }
        //第i天没有股票  dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //第i天有股票  dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        int pre0 = 0;
        int cur0 = Math.max(prices[1]-prices[0],0);
        int cur1 = Math.max(-prices[0],-prices[1]);
        for(int i=2; i<prices.length; i++){
            int temp = cur0;
            cur0 = Math.max(cur0,cur1+prices[i]);
            cur1 = Math.max(cur1,pre0-prices[i]);
            pre0 = temp;
        }
        return cur0;
    }

    //股票卖出后需要间隔一天才可以买
    public int maxProfit2(int[] prices) {
        if(prices.length<=1) {
            return 0;
        }
        if(prices.length==2){
            return Math.max(prices[1]-prices[0],0);
        }
        //第i天没有股票  dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //第i天有股票  dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        int[][] dp = new int[prices.length][3];
        dp[1][0] = Math.max(prices[1]-prices[0],0);
        dp[1][1] = Math.max(-prices[0],-prices[1]);
        for(int i=2; i<prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
