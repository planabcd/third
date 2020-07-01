package binary;

/**
 * @author think
 * @version v 1.0 2020/7/2 0:33
 */
public class KthSmallesElementInASortedMatrix378 {
    //378. 有序矩阵中第K小的元素
    //给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
    //请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
    //
    //
    //
    //示例：
    //
    //matrix = [
    //        [ 1,  5,  9],
    //        [10, 11, 13],
    //        [12, 13, 15]
    //        ],
    //k = 8,
    //
    //返回 13。
    //https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(new KthSmallesElementInASortedMatrix378().kthSmallest(matrix,8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //矩阵中最小的值在左上角
        int left = matrix[0][0];
        //矩阵中最大的值在右下角
        int right = matrix[rows-1][cols-1];
        while(left<right){
            int mid = left + (right-left)/2;
            int countMid = countLessThanAndEqualsMid(matrix,mid,rows,cols);
            //小于等于mid的元素个数如果小于k个,说明mid肯定不是第k小的元素
            if(countMid<k){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int countLessThanAndEqualsMid(int[][] matrix, int mid, int rows, int cols) {
        int row = rows-1;
        int col = 0;
        int count = 0;
        //从左下角开始,如果当前元素matrix[row][col]<=mid,说明当前列colIndex=col有row+1个元素是小于等于mid的
        while(row>=0 && col<=cols-1){
            if(matrix[row][col]<=mid){
                count+=(row+1);
                col++;
            }else{
                row--;
            }
        }
        return count;
    }

}
