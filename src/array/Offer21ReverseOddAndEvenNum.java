package array;

/**
 * @author think
 * @version v 1.0 2019/12/21 17:55
 */
public class Offer21ReverseOddAndEvenNum {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        helper(array,0,array.length-1);
    }

    private void helper(int[] array, int start, int end) {
        if(start>=end){
            return;
        }
        int mid = (end-start)/2+start;
        helper(array,start,mid);
        helper(array,mid+1,end);
        merge(array,start,mid,end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int[] tempArray = new int[end-start+1];
        int index = 0;
        while(i<=mid && j<=end){
            if(array[i]%2==1){
                tempArray[index++] = array[i++];
            }
            if(array[j]%2==1){
                tempArray[index++] = array[j++];
            }
        }
    }

}
