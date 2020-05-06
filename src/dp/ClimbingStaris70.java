package dp;

/**
 * @author think
 * @version v 1.0 2019/12/3 23:08
 */
public class ClimbingStaris70 {
    public static void main(String[] args) {
        int res = new ClimbingStaris70().climbStairs(5);
        System.out.println(res);
    }

    public int climbStairs(int n) {
        if(n<=3){
            return n;
        }
        int pre = 2;
        int cur = 3;
        for(int i=4; i<=n; i++){
            int temp = cur;
            cur  = cur+pre;
            pre = temp;
        }
        return cur;
    }


    public int climbStairs2(int n) {
        if (n <= 3) {
            return n;
        }
        int pre = 2;
        int cur = 3;
        for (int i = 4; i <= n; i++) {
            int temp = cur;
            cur = cur + pre;
            pre = temp;
        }
        return cur;
    }
}
