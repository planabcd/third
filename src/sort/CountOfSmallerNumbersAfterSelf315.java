package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/7/11 11:33
 */
public class CountOfSmallerNumbersAfterSelf315 {
    //315. 计算右侧小于当前元素的个数
    //给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
    //
    //示例:
    //
    //输入: [5,2,6,1]
    //输出: [2,1,1,0]
    //解释:
    //        5 的右侧有 2 个更小的元素 (2 和 1).
    //        2 的右侧仅有 1 个更小的元素 (1).
    //        6 的右侧有 1 个更小的元素 (1).
    //        1 的右侧有 0 个更小的元素.
    //https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
    public static void main(String[] args) {
        List<Integer> res = new CountOfSmallerNumbersAfterSelf315().countSmaller(new int[]{5,2,6,1});
        for (Integer re : res) {
            System.out.print(re+"\t");
        }
    }


    int[] indexArr;
    int[] result;
    public List<Integer> countSmaller(int[] nums) {
        //归并排序的过程中计算逆序个数
        //假设有序数组A=[4,6,8],B=[3,5,9]
        //A[i]出队的时候,B中已出队的元素均小于A[i],所以result[i]=j-(mid+1)
        //如果B[j]全部出队,则result[i]=r-mid
        indexArr = new int[nums.length];
        result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexArr[i] = i;
        }
        mergeSort(nums,0,nums.length-1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l>=r){
            return;
        }
        int mid = l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        if(nums[indexArr[mid]]>nums[indexArr[mid+1]]){
            mergeAndCount(nums, l, mid, r);
        }
    }

    //nums  3,5 1,7
    //index 0,1 2,3
    //
    private void mergeAndCount(int[] nums, int l,int mid, int r) {
        int[] temp = new int[r-l+1];
        int i=l;
        int j=mid+1;
        int k = 0;
        while(i<=mid && j<=r){
            if(nums[indexArr[i]]<=nums[indexArr[j]]){
                //左侧出队
                result[indexArr[i]] += j-(mid+1);
                temp[k++] = indexArr[i++];
            }else{
                temp[k++] = indexArr[j++];
            }
        }
        while(i<=mid){
            result[indexArr[i]] += r-(mid+1)+1;
            temp[k++] = indexArr[i++];
        }
        while(j<=r){
            temp[k++] = indexArr[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            indexArr[l+m] = temp[m];
        }
    }
}
