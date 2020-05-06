package dfs;

import java.util.Stack;

/**
 * @author think
 * @version v 1.0 2020/1/8 1:10
 */
public class DecodeString394 {
    //给定一个经过编码的字符串，返回它解码后的字符串。
    //
    //编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    //
    //你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    //
    //此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
    //
    //示例:
    //
    //s = "3[a]2[bc]", 返回 "aaabcbc".
    //s = "3[a2[c]]", 返回 "accaccacc".
    //s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/decode-string

    public static void main(String[] args) {
        System.out.println(new DecodeString394().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        if(s.length()==0){
            return "";
        }
        Stack<String> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int repeatNum = 0;
        for (char c : s.toCharArray()) {
            if('['==c){
                charStack.push(res.toString());
                numStack.push(repeatNum);
                res = new StringBuilder();
                repeatNum = 0;
            }else if(']'==c){
                Integer pop = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < pop; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(charStack.pop()).append(temp.toString());
            }else if(c>='0' && c<='9'){
                repeatNum =  repeatNum*10 + Integer.valueOf(c+"");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
