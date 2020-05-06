package array;

/**
 * @author think
 * @version v 1.0 2020/1/16 0:51
 */
public class FindTheDuplicateNumber287 {

    public static void main(String[] args) {
        //int[] array = {3,1,3,4,2};
        //System.out.println(new FindTheDuplicateNumber287().findDuplicate(array));
        String a = new String("abc");
        String b = new String("abc");
        System.out.println(((a+"abc")==(b+"abc")));
    }

    static class MyThread implements Runnable{
        String s;
        MyThread(String s){
            this.s = s;
        }

        @Override
        public void run() {
            invalid(s);
        }
    }

    public static void invalid(String s){
        System.out.println(s.hashCode());
        synchronized (s.intern()){
            try {
                System.out.println("lock:"+s);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     *
     * 示例 1:
     *
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [3,1,3,4,2]
     * 输出: 3
     * 说明：
     *
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://dev.lingkou.xyz/problems/find-the-duplicate-number
     */

    public int findDuplicate(int[] nums) {
        if(nums.length<=1){
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(nums[slow]!=nums[fast]){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p0 = nums[0];
        int p1 = nums[fast];
        while(p0!=p1){
            p0 = nums[p0];
            p1 = nums[p1];
        }
        return p0;
    }
}
