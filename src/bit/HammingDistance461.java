package bit;

/**
 * @author liaoxin
 * @version v 1.0 2020/1/29 20:57
 */
public class HammingDistance461 {
    //两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
    //
    //给出两个整数 x 和 y，计算它们之间的汉明距离。
    //
    //注意：
    //        0 ≤ x, y < 231.
    //
    //示例:
    //
    //输入: x = 1, y = 4
    //
    //输出: 2
    //
    //解释:
    //        1   (0 0 0 1)
    //        4   (0 1 0 0)
    //        ↑   ↑
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/hamming-distance

    public static void main(String[] args) {
        System.out.println(new HammingDistance461().hammingDistance(1,4));
    }

    public int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while(z!=0){
            z = z & (z-1);
            count++;
        }
        return count;
    }

}
