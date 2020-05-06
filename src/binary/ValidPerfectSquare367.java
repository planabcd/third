package binary;

/**
 * @author think
 * @version v 1.0 2019/12/2 22:49
 */
public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        int left = 1;
        int right = num/2;
        int mid = 0;
        while(left <= right){
            mid = (right-left)/2+left;
            long target = mid*mid;
            if(target==num){
                return true;
            }else if(target>num){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
