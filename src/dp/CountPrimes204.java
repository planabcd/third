package dp;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2020/1/12 13:11
 */
public class CountPrimes204 {
    //统计所有小于非负整数 n 的质数的数量。
    //
    //示例:
    //
    //输入: 10
    //输出: 4
    //解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        //dp[n] = true表示当前数为质数
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, true);
        for (int i = 2; i * i < n; i++) {
            if (dp[i]) {
                for (int j = 2; j * i < n; j++) {
                    dp[j * i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                count++;
            }
        }
        return count;
    }


}