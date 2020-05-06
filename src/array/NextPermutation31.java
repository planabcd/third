package array;

/**
 * @author think
 * @version v 1.0 2020/1/12 14:02
 */
public class NextPermutation31 {
    //实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    //
    //如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    //
    //必须原地修改，只允许使用额外常数空间。
    //
    //以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    //        1,2,3 → 1,3,2
    //        3,2,1 → 1,2,3
    //        1,1,5 → 1,5,1
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/next-permutation

    public static void main(String[] args) {
        new NextPermutation31().nextPermutation(new int[]{1,3,2});
    }

    public void nextPermutation(int[] nums) {
        //4 1 3 5 2
        //1.从后往前找到第一个不逆序的数字 3
        //2.交换第一个不逆序的数字和逆序区的 最小数字 3和5交换  4 1 5 3 2
        //3.逆序区转为顺序 4 1 5 2 3
        if(nums.length<=1){
            return;
        }
        //4 3 5 1 2
        int lastIndex = 0;
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]<nums[i+1]){
                lastIndex = i+1;
                break;
            }
        }
        //5 1 4 3 2->5 2 1 3 4
        if(lastIndex==0){
            revers(nums,0,nums.length-1);
            return;
        }
        for (int i = nums.length-1; i >=lastIndex ; i--) {
            if(nums[lastIndex-1]<nums[i]){
                int temp = nums[lastIndex-1];
                nums[lastIndex-1] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        revers(nums,lastIndex,nums.length-1);
    }


    private void revers(int[] nums, int start, int end) {
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
