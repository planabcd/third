package bit;

/**
 * @author think
 * @version v 1.0 2019/12/13 0:07
 */
public class CountingBits338 {
    public static void main(String[] args) {
        int[] ints = new CountingBits338().countBits(16);
        for (int anInt : ints) {
            System.out.print(anInt+"\t");
        }
    }

    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 1; i <= num; i++) {
            if(i%2==0){
                dp[i] = dp[i>>1];
            }else{
                dp[i] = dp[i-1]+1;
            }
        }
        return dp;
    }

}
