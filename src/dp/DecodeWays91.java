package dp;

/**
 * @author think
 * @version v 1.0 2019/12/8 15:20
 */
public class DecodeWays91 {
    public static void main(String[] args) {
        int res = new DecodeWays91().numDecodings("226");
        System.out.println(res);
    }

    //一条包含字母 A-Z 的消息通过以下方式进行了编码：
    //
    //        'A' -> 1
    //        'B' -> 2
    //        ...
    //        'Z' -> 26
    //给定一个只包含数字的非空字符串，请计算解码方法的总数。
    //
    //示例 1:
    //
    //输入: "12"
    //输出: 2
    //解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
    //示例 2:
    //
    //输入: "226"
    //输出: 3
    //解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/decode-ways

    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if(s.charAt(i-1)>'0'){
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)<'7'){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }


        public int numDecodings3(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='0'){
            return 0;
        }
        int pre = 1;
        int cur = 1;
        for(int i=2; i<=s.length(); i++){
            int temp = 0;
            if(s.charAt(i-1)>'0'){
                temp = cur;
            }
            if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')){
                temp += pre;
            }
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public int numDecodings2(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='0'){
            return 0;
        }
        //dp[i]表示长度为i的字符串可以解码的数量
        //dp[i] = dp[i-1]+dp[i-2];
        //17-> 1+7,0+17
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        //12601 -> 126+1260
        for(int i=2; i<=s.length(); i++){
            if(s.charAt(i-1)>'0'){
                dp[i]=dp[i-1];
            }
            if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public void fb(int n){
        if(n<=3){
            return;
        }
        int f0 = 1;
        int f1 = 2;
        int f2 = 3;
        for(int i=4; i<=n; i++){
            f2 = f0+f1;
            f0 = f1;
            f1 =f2;
            System.out.println(f2);
        }
    }
}
