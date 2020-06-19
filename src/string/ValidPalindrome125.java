package string;

/**
 * @author think
 * @version v 1.0 2020/6/20 1:00
 */
public class ValidPalindrome125 {
    //125. 验证回文串
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    //
    //说明：本题中，我们将空字符串定义为有效的回文串。
    //
    //示例 1:
    //
    //输入: "A man, a plan, a canal: Panama"
    //输出: true
    //示例 2:
    //
    //输入: "race a car"
    //输出: false
    //https://leetcode-cn.com/problems/valid-palindrome/
    public static void main(String[] args) {
        //System.out.println(new ValidPalindrome125().isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(new ValidPalindrome125().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome125().isPalindrome("0P"));
    }


    public boolean isPalindrome(String s) {
        if(s.length()<=1){
            return true;
        }
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(i<j && !isChar(s.charAt(i))){
                i++;
            }
            while(i<j && !isChar(s.charAt(j))){
                j--;
            }
            if(i<j){
                if(!isSame(s.charAt(i),s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }

        }
        return true;
    }

    private boolean isSame(char a, char b) {
        if(a>='A' && a<='Z'){
            a = (char)(a+32);
        }
        if(b>='A' && b<='Z'){
            b = (char)(b+32);
        }
        return a==b;

    }

    private boolean isChar(char c){
        if(c>='a' && c<='z'){
            return true;
        }
        if(c>='A' && c<='Z'){
            return true;
        }
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }
    
}
