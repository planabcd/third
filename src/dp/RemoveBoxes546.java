package dp;

/**
 * @author think
 * @version v 1.0 2020/8/15 10:02
 */
public class RemoveBoxes546 {
    //546. 移除盒子
    //给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
    //你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
    //当你将所有盒子都去掉之后，求你能获得的最大积分和。
    //
    //
    //
    //示例：
    //
    //输入：boxes = [1,3,2,2,2,3,4,3,1]
    //输出：23
    //解释：
    //        [1, 3, 2, 2, 2, 3, 4, 3, 1]
    //        ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
    //        ----> [1, 3, 3, 3, 1] (1*1=1 分)
    //        ----> [1, 1] (3*3=9 分)
    //        ----> [] (2*2=4 分)
    //
    //
    //提示：
    //
    //        1 <= boxes.length <= 100
    //        1 <= boxes[i] <= 100
    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return helper(boxes, dp, 0, boxes.length-1, 0);
    }

    private int helper(int[] boxes, int[][][] dp, int l, int r, int k) {
        if(r>l){
            return 0;
        }
        if(dp[l][r][k]!=0){
            return dp[l][r][k];
        }
        while(l>r && boxes[r]==boxes[r-1]){
            r--;
            k++;
        }
        //dp[l][r][k]示移除区间[l,r] 加上该区间右边等于boexs[r]的 k个元素组成的这个序列的最大积分
        //l到r,boxes[r:]包含个k个boxse[r]
        dp[l][r][k] = helper(boxes, dp, l, r-1, 0) + (k+1)*(k+1);
        for (int i = l; i <r ; i++) {
            if(boxes[i]==boxes[r]){
                //从boxse[r-1:]从后往前找a[i]==boxse[r]
                //1,5,6,2,2,6,6,6,6
                //i = 2时, dp[0,2,4+1]
                dp[l][r][k] = Math.max(
                        dp[l][r][k],helper(boxes, dp, l, i, k+1)+helper(boxes, dp, i+1,r-1, 0)
                );
            }
        }
        return dp[l][r][k];
    }
}
