package bit;

/**
 * @author think
 * @version v 1.0 2019/12/12 23:55
 */
public class PowerOfTwo213 {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & n-1)==0;
    }
}
