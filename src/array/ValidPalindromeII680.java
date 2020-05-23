package array;

/**
 * @author think
 * @version v 1.0 2020/5/19 23:36
 */
public class ValidPalindromeII680 {
    //680. 验证回文字符串 Ⅱ
    //给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    //
    //示例 1:
    //
    //输入: "aba"
    //输出: True
    //示例 2:
    //
    //输入: "abca"
    //输出: True
    //解释: 你可以删除c字符。
    //注意:
    //
    //字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
    //https://leetcode-cn.com/problems/valid-palindrome-ii/
    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII680().validPalindrome("aba"));
        System.out.println(new ValidPalindromeII680().validPalindrome("abca"));

    }
    public boolean validPalindrome(String s) {
        if(s.length()<=1){
            return true;
        }
        for (int i = 0,j=s.length()-1; i < j; i++,j--) {
            if(s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
