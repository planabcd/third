package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/8/10 23:00
 */
public class CountBinarySubstrings696 {
    //696. 计数二进制子串
    //给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
    //
    //重复出现的子串要计算它们出现的次数。
    //
    //示例 1 :
    //
    //输入: "00110011"
    //输出: 6
    //解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
    //
    //请注意，一些重复出现的子串要计算它们出现的次数。
    //
    //另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
    //示例 2 :
    //
    //输入: "10101"
    //输出: 4
    //解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
    //注意：
    //
    //s.length 在1到50,000之间。
    //s 只包含“0”或“1”字符。
    //https://leetcode-cn.com/problems/count-binary-substrings/
    public static void main(String[] args) {
        int res = new CountBinarySubstrings696().countBinarySubstrings("00110011");
        System.out.println(res);
    }

    public int countBinarySubstrings(String s) {
        int index = 0;
        //000011100->转换为连续0或者连续1的个数集合,4,3,2
        //然后res = min(4,3)+min(3,2)
        List<Integer> continueCont = new ArrayList<>();
        while(index<s.length()){
            int count = 0;
            int start = index;
            char c = s.charAt(start);
            while(start<s.length() && s.charAt(start)==c){
                count++;
                start++;
            }
            index = start;
            continueCont.add(count);
        }
        int count = 0;
        for (int i = 1; i < continueCont.size(); i++) {
            count+= Math.min(continueCont.get(i),continueCont.get(i-1));
        }
        return count;
    }

}
