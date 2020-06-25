package bit;

/**
 * @author think
 * @version v 1.0 2020/6/23 23:24
 */
public class AddBinary67 {
    //67. 二进制求和
    //给你两个二进制字符串，返回它们的和（用二进制表示）。
    //
    //输入为 非空 字符串且只包含数字 1 和 0。
    //
    //
    //
    //示例 1:
    //
    //输入: a = "11", b = "1"
    //输出: "100"
    //示例 2:
    //
    //输入: a = "1010", b = "1011"
    //输出: "10101"
    //
    //
    //提示：
    //
    //每个字符串仅由字符 '0' 或 '1' 组成。
    //        1 <= a.length, b.length <= 10^4
    //字符串如果不是 "0" ，就都不含前导零。
    //https://leetcode-cn.com/problems/add-binary/
    public static void main(String[] args) {
        System.out.println(new AddBinary67().addBinary("1010", "1011"));
        System.out.println(new AddBinary67().addBinary("11", "1"));
    }
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        StringBuilder str = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < length; i++) {
            int num1 = i<a.length()?a.charAt(a.length()-i-1)-'0':0;
            int num2 = i<b.length()?b.charAt(b.length()-i-1)-'0':0;
            int num = num1+num2+carry;
            if(num==0){
                str.append(0);
                carry = 0;
            }else if(num==1){
                str.append(1);
                carry = 0;
            }else if(num==2){
                str.append(0);
                carry=1;
            }else if(num==3){
                str.append(1);
                carry = 1;
            }
        }
        if(carry==1){
            str.append(1);
        }
        return str.reverse().toString();
    }
}
