package bit;

/**
 * @author think
 * @version v 1.0 2019/12/12 23:54
 */
public class NumberOf1Bit191 {
    public int hammingWeight(int n) {
        if(n==0){
            return 0;
        }
        int count = 0;
        while(n!=0){
            count++;
            n = n & n-1;
        }
        return count;
    }
}
