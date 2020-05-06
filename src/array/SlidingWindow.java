package array;

import java.util.LinkedList;

/**
 * @author think
 * @version v 1.0 2019/9/30 23:11
 */
public class SlidingWindow {
    public static void main(String[] args) {
        final int[] ints = {1,3,1,2,0,5};
        final int[] ints1 = new SlidingWindow().maxSlidingWindow(ints, 3);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i!=nums.length; i++){
            if(i>=k && list.getFirst()<=i-k){
                list.removeFirst();
            }
            while(!list.isEmpty() && nums[list.getLast()]<nums[i]){
                list.removeLast();
            }
            list.addLast(i);
            if(i>=k-1){
                result[i-k+1] = nums[list.getFirst()];
            }
        }
        return result;
    }
}
