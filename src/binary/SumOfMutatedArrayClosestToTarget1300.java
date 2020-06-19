package binary;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2020/6/14 11:00
 */
public class SumOfMutatedArrayClosestToTarget1300 {
    //1300. 转变数组后最接近目标值的数组和
    //给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
    //
    //如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
    //
    //请注意，答案不一定是 arr 中的数字。
    //
    //
    //
    //示例 1：
    //
    //输入：arr = [4,9,3], target = 10
    //输出：3
    //解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
    //示例 2：
    //
    //输入：arr = [2,3,5], target = 10
    //输出：5
    //示例 3：
    //
    //输入：arr = [60864,25176,27249,21296,20204], target = 56803
    //输出：11361
    //
    //提示:
    //1 <= arr.length <= 10^4
    //1 <= arr[i], target <= 10^5
    //https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
    public static void main(String[] args) {
        System.out.println(new SumOfMutatedArrayClosestToTarget1300().findBestValue(new int[]{60864,25176,27249,21296,20204},56803));
        System.out.println(new SumOfMutatedArrayClosestToTarget1300().findBestValue(new int[]{2,3,5},10));
        System.out.println(new SumOfMutatedArrayClosestToTarget1300().findBestValue(new int[]{4,9,3},10));

    }

    public int findBestValue(int[] arr, int target) {
        if(arr.length==0){
            return 0;
        }
        Arrays.sort(arr);
        //dp[i]=arr[0]+arr[1]+...+arr[i-1]
        int[] dp = new int[arr.length+1];
        for (int i = 1; i <=arr.length ; i++) {
            dp[i] = dp[i-1]+arr[i-1];
        }
        //二分查找最大的上界就是数组里最大的数字
        int right = arr[arr.length-1];
        int left = arr[0];
        //假设从i开始都被替换为value,则求和公式如下:
        //sum = arr[0]+arr[1]+...+arr[i-1]+((arr.length-1-i)+1))*value
        //sum = dp[i-1]*(arr.length-i)*value
        //value从1到arr[i-1]依次增加
        //ex:arr = {3,4,9},i=3,i=4,i=5
        int distance = Integer.MAX_VALUE;
        int res = 0;
        //题意给的提示,下边界是1,并不是数组里最小的元素,因为我们期望的是sum(arr)最接近target,如果target比最小的元素还小呢?
        //上边界是max(arr),因为只有大于value的值才会被替换,所以如果上边界大于数组里的任何元素,sum和不替换没啥不一样
        for (int value = 0; value <= right; value++) {
            //寻找value,第一个比arr[value]大的数字
            int index = binarySearch(arr,value);
            int sum = dp[index]+(arr.length-index)*value;
            int newDistance = Math.abs(sum-target);
            if(newDistance<distance){
                distance = newDistance;
                res = value;
            }
        }
        return res;
    }

    //如果未找到,需要返回第一个比target大的元素
    //1,3,5,7,9,find 6,return 7
    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public int findBestValue2(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[n - 1];
        int ans = 0, diff = target;
        for (int i = 1; i <= r; ++i) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }
}
