package dp;

/**
 * @author think
 * @version v 1.0 2019/12/7 19:11
 */
public class CoinChangeII518 {
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int change = new CoinChangeII518().change(5, coins);
        System.out.println(change);
    }

    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        if(coins.length==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int k=1; k*coins[0]<=amount; k++){
            dp[k*coins[0]] = 1;
        }
        for(int i=1; i<coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(j>=coins[i]){
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        if(coins.length==0){
            return 0;
        }
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j*coins[0]<=amount; j++){
            dp[0][coins[0]*j] = 1;
        }
        for(int i=1; i<coins.length; i++){
            for(int j=1; j<=amount; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=coins[i]){
                    dp[i][j] += dp[i][j-coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];
    }

    public int change2(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        if(coins.length==0){
            return 0;
        }
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j*coins[0]<=amount; j++){
            dp[0][coins[0]*j] = 1;
        }
        for(int i=1; i<coins.length; i++){
            for(int j=1; j<=amount; j++){
                for(int k=0; k*coins[i]<=j; k++){
                    dp[i][j]+=dp[i-1][j-k*coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];
    }

    private void printArray(int[][] dp) {
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }

    }
}
