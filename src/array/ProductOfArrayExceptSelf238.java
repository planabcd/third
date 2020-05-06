package array;

/**
 * @author liaoxin
 * @version v 1.0 2020/1/31 20:19
 */
public class ProductOfArrayExceptSelf238 {
    //给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
    //
    //示例:
    //
    //输入: [1,2,3,4]
    //输出: [24,12,8,6]
    //说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
    //
    //进阶：
    //你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/product-of-array-except-self

    public static void main(String[] args) {
        int[] ints = new ProductOfArrayExceptSelf238().productExceptSelf(new int[]{1, 2, 3, 4});
        //1,1,2,6
        //24,12,8,6
        for (int anInt : ints) {
            System.out.print(anInt+"\t");
        }
    }
    //空间复杂度O(1)
    public int[] productExceptSelf(int[] nums) {
        if(nums.length<=1){
            return new int[]{1};
        }
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1]*nums[i-1];
        }
        //从右往左的累乘积
        int r = 1;
        for (int i = nums.length-1; i >=0; i--) {
            result[i] = result[i]*r;
            r = r*nums[i];
        }
        return result;
    }

    //空间复杂度O(N)
    public int[] productExceptSelf1(int[] nums) {
        if(nums.length<=1){
            return new int[]{1};
        }
        //left[i]表示从nums[0]*nums[1]*...nums[i-1]
        int[] left = new int[nums.length];
        left[0] = 1;
        //right[i]表示从nums[nums.length-1]*nums[nums.length-2]*...nums[i+1]
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        for (int i = nums.length-2; i >=0 ; i--) {
            right[i] = right[i+1]*nums[i+1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i]*right[i];
        }
        return res;
    }
}
