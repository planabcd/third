package string;

/**
 * @author think
 * @version v 1.0 2020/8/24 1:26
 */
public class RepeatedSubstringPattern459 {
    //459. 重复的子字符串
    //给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
    //
    //示例 1:
    //
    //输入: "abab"
    //
    //输出: True
    //
    //解释: 可由子字符串 "ab" 重复两次构成。
    //示例 2:
    //
    //输入: "aba"
    //
    //输出: False
    //示例 3:
    //
    //输入: "abcabcabcabc"
    //
    //输出: True
    //
    //解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
    //https://leetcode-cn.com/problems/repeated-substring-pattern/
    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern459().repeatedSubstringPattern("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(0,i);
            int start = 0;
            boolean match = true;
            while(start<s.length()){
                if(start+str.length()>s.length()){
                    match = false;
                    break;
                }
                if(!s.substring(start,start+str.length()).equals(str)){
                    match = false;
                    break;
                }else{
                    start+=str.length();
                }
            }
            if(match){
                return true;
            }
        }
        return false;
    }
}
