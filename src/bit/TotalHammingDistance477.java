package bit;

/**
 * @author liaoxin
 * @version v 1.0 2020/1/29 20:57
 */
public class TotalHammingDistance477 {
    //两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
    //
    //计算一个数组中，任意两个数之间汉明距离的总和。
    //
    //示例:
    //
    //输入: 4, 14, 2
    //
    //输出: 6
    //
    //解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
    //所以答案为：
    //HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
    //注意:
    //
    //数组中元素的范围为从 0到 10^9。
    //数组的长度不超过 10^4。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/total-hamming-distance

    public static void main(String[] args) {
        System.out.println(new TotalHammingDistance477().totalHammingDistance(new int[]{4,14,2}));
    }

    public int totalHammingDistance(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int count = 0;
        int[] countArray = new int[30];
        //countArray[0]表示nums数组中每个数字对应第0位为1的个数
        for (int num : nums) {
            int bitIndex =  0;
            while(num!=0){
                if((num & 1) ==1){
                    countArray[bitIndex]++;
                }
                num = num>>1;
                bitIndex++;
            }
        }
        for (int i = 0; i < countArray.length; i++) {
            int oneCount = countArray[i];
            int zeroCount = nums.length-oneCount;
            count += oneCount*zeroCount;
        }
        return count;
    }

}
