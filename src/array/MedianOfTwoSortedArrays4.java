package array;

/**
 * @author think
 * @version v 1.0 2020/5/26 0:08
 */
public class MedianOfTwoSortedArrays4 {
    //4. 寻找两个正序数组的中位数
    //给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
    //
    //请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //
    //你可以假设 nums1 和 nums2 不会同时为空。
    //
    //
    //
    //示例 1:
    //
    //nums1 = [1, 3]
    //nums2 = [2]
    //
    //则中位数是 2.0
    //示例 2:
    //
    //nums1 = [1, 2]
    //nums2 = [3, 4]
    //
    //则中位数是 (2 + 3)/2 = 2.5
    //https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        //如果有偶数个,左右两侧个数相等
        //如果有奇数个,左侧比右侧多一个
        int leftTotal = (nums1.length+nums2.length+1)/2;
        int left = 0;
        int right = nums1.length;
        int i;
        int j;
        while(left<right){
            i = (left+right+1)/2;
            j = leftTotal - i;
            if(nums1[i-1]>nums2[j]){
                right = i-1;
            }else{
                left = i;
            }
        }
        i = left;
        j = leftTotal-i;
        int leftNums1Max = i==0?Integer.MIN_VALUE:nums1[i-1];
        int leftNums2Max = j==0?Integer.MIN_VALUE:nums2[j-1];
        int rightNums1Min = i== nums1.length?Integer.MAX_VALUE:nums1[i];
        int rightNums2Min = j==nums2.length?Integer.MAX_VALUE:nums2[j];
        if((nums1.length+nums2.length)%2==0){
            return (double)(Math.max(leftNums1Max,leftNums2Max)+Math.min(rightNums1Min,rightNums2Min))/2;
        }else{
            return Math.max(leftNums1Max,leftNums2Max);
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
