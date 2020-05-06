package dp;

/**
 * @author think
 * @version v 1.0 2019/12/4 0:22
 */
public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {
        int res = new LongestCommonSubsequence1143().longestCommonSubsequence("bl", "yby");
        System.out.println(res);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0){
            return 0;
        }
        int rows = text1.length();
        int cols = text2.length();
        int[][] dp = new int[rows+1][cols+1];
        char[] rowChars = text1.toCharArray();
        char[] colChars = text2.toCharArray();
        //for(int i=1; i<=rows; i++){
        //    if(dp[i-1][1]==1){
        //        dp[i][1]=1;
        //    }else if(rowChars[i-1]==colChars[0]){
        //        dp[i][1] = 1;
        //    }
        //}
        //for(int i=1; i<=cols; i++){
        //    if(dp[1][i-1]==1){
        //        dp[1][i] =1;
        //    }else if(rowChars[0]==colChars[i-1]){
        //        dp[1][i] = 1;
        //    }
        //}
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                if(rowChars[i-1]==colChars[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        return dp[rows][cols];
    }

}
