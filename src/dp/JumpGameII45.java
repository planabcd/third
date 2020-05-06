package dp;

/**
 * @author think
 * @version v 1.0 2019/12/1 17:09
 */
public class JumpGameII45 {
    //给定一个非负整数数组，你最初位于数组的第一个位置。
    //
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    //
    //示例:
    //
    //输入: [2,3,1,1,4]
    //输出: 2
    //解释: 跳到最后一个位置的最小跳跃数是 2。
    //             从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    //说明:
    //
    //假设你总是可以到达数组的最后一个位置。
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int result = new JumpGameII45().jump(nums);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int step = 0;
        int end = 0;
        int maxIndex = 0;
        //nums.length-1作为下界,避免后面某步直接跳到终点的情况
        for(int i=0; i!=nums.length-1; i++){
            maxIndex = Math.max(nums[i]+i,maxIndex);
            if(i==end){
                step++;
                end = maxIndex;
            }
        }
        return step;
    }


}
