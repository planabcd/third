package dp;

/**
 * @author think
 * @version v 1.0 2019/12/1 16:29
 */
@SuppressWarnings("all")
public class BestTimeToBuyAndSellStockWithTransactionFee714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int i = new BestTimeToBuyAndSellStockWithTransactionFee714().maxProfit(prices,2);
        System.out.println(i);
    }

    public int maxProfit(int[] prices, int fee) {
        if(prices.length<=1){
            return 0;
        }
        int pre0 = 0;
        int pre1 = -prices[0];
        for(int i=1; i<prices.length; i++){
            int temp = pre0;
            pre0 = Math.max(temp,pre1+prices[i]-fee);
            pre1 = Math.max(pre1,temp-prices[i]);
        }
        return pre0;
    }

    public int maxProfit2(int[] prices, int fee) {
        if(prices.length<=1){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for(int i=1; i<prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
