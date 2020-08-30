package string;

/**
 * @author think
 * @version v 1.0 2020/8/30 17:17
 */
public class ReverseWordsInAStringIII557 {
    //557. 反转字符串中的单词 III
    //给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    //
    //
    //
    //示例：
    //
    //输入："Let's take LeetCode contest"
    //输出："s'teL ekat edoCteeL tsetnoc"
    //
    //
    //提示：
    //
    //在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
    //https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII557().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if(s.length()<=1){
            return s;
        }
        int i = 0;
        int j = 1;
        char[] chars = s.toCharArray();
        while(j<chars.length){
            if(chars[j]==' ' || j+1==chars.length){
                int right = j+1==chars.length?j:j-1;
                reverse(chars, i,right);
                i = j+1;
            }
            j++;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while(left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
