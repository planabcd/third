package binary;

/**
 * @author think
 * @version v 1.0 2019/12/21 13:05
 */
public class FindFirstRepeatTargetNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,5,6,6,7,8,8};
        final int targetNum = new FindFirstRepeatTargetNum().findTargetNum(arr, 1);
        System.out.println(targetNum);
    }

    public int findTargetNum(int[] arr,int target){
        if(arr.length==0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        int mid;
        while(start<=end){
            mid = (end-start)/2+start;
            if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                if(mid==0 || arr[mid-1]!=target){
                    return mid;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
