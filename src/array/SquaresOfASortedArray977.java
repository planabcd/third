package array;

/**
 * @author think
 * @version v 1.0 2020/10/16 0:05
 */
public class SquaresOfASortedArray977 {
    //977. 有序数组的平方
    //给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    //
    //
    //
    //示例 1：
    //
    //输入：[-4,-1,0,3,10]
    //输出：[0,1,9,16,100]
    //示例 2：
    //
    //输入：[-7,-3,2,3,11]
    //输出：[4,9,9,49,121]
    //
    //
    //提示：
    //
    //        1 <= A.length <= 10000
    //        -10000 <= A[i] <= 10000
    //A 已按非递减顺序排序。
    public int[] sortedSquares(int[] A) {
        if(A.length==0){
            return new int[]{};
        }
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length-1;
        int index = A.length-1;
        while(index>=0){
            int a = Math.abs(A[left]);
            int b = Math.abs(A[right]);
            if(a<b){
                res[index--] = b*b;
                right--;
            }else{
                res[index--] = a*a;
                left++;
            }
        }
        return res;
    }
}
