package array;

/**
 * @author think
 * @version v 1.0 2019/11/24 9:16
 */
public class SignleNumber136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i !=nums.length; i++) {
            res = res^nums[i];
        }
        return res;
    }
}
