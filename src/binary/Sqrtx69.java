package binary;

/**
 * @author think
 * @version v 1.0 2019/12/21 12:28
 */
public class Sqrtx69 {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        long start = 1;
        long end = x/2;
        long mid;
        while(start<=end){
            mid = (end-start)/2+start;
            if(mid*mid==x){
                return (int)mid;
            }else if(mid*mid>x){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if(start*start<x){
            return (int)start;
        }
        return (int)(start-1);
    }
}
