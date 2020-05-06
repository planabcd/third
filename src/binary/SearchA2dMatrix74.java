package binary;

/**
 * @author think
 * @version v 1.0 2019/12/2 23:44
 */
public class SearchA2dMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0|| matrix[0].length==0){
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int left = 0;
        int right = rowNum*colNum-1;
        int mid;
        while(left<=right){
            mid = (right-left)/2+left;
            int row = mid/colNum;
            int col = mid< colNum ? mid :mid%(row*colNum);
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
        public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while(row>=0 && col<=matrix[0].length-1){
            if(target==matrix[row][col]){
                return true;
            }else if(target<matrix[row][col]){
                row--;
            }else{
                col++;
            }
        }
        return false;
    }
}
