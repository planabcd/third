package dp;

/**
 * @author think
 * @version v 1.0 2019/12/27 22:27
 */
public class BestTimeToBuyAndSellStock121 {
    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //
    //如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    //
    //注意你不能在买入股票前卖出股票。
    //
    //示例 1:
    //
    //输入: [7,1,5,3,6,4]
    //输出: 5
    //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    //注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    //示例 2:
    //
    //输入: [7,6,4,3,1]
    //输出: 0
    //解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock121().maxProfit(new int[]{7,2,11,1,6,9});
    }


    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int res = 0;
        int minIndex = 0;
        int min = prices[minIndex];
        int start = minIndex;
        int end = minIndex;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<min){
                minIndex = i;
            }else{
                if(prices[i]-min>res){
                    res = prices[i]-min;
                    start = minIndex;
                    end = i;
                }
            }
        }
        //最佳买点和卖点
        System.out.println("start->end:"+start+"->"+end);
        return res;
    }
}
