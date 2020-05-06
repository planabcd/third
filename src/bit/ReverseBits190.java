package bit;

/**
 * @author think
 * @version v 1.0 2019/12/13 0:04
 */
public class ReverseBits190 {
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
