package array;

/**
 * @author think
 * @version v 1.0 2020/1/5 16:00
 */
public class TrappingRainWater42 {
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //
    //
    //上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
    //
    //示例:
    //
    //输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出: 6
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/trapping-rain-water
    public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        //以i为中心到达的最高左边界高度
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i],left[i-1]);
        }
        //以i为中心到达的最高右边界高度
        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0 ; i--) {
            right[i] = Math.max(height[i],right[i+1]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum+= Math.min(left[i],right[i])-height[i];
        }
        return sum;
    }


}
