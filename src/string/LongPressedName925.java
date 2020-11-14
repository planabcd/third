package string;

/**
 * @author think
 * @version v 1.0 2020/10/21 23:06
 */
public class LongPressedName925 {
    //925. 长按键入
    //你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
    //
    //你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
    //
    //
    //
    //示例 1：
    //
    //输入：name = "alex", typed = "aaleex"
    //输出：true
    //解释：'alex' 中的 'a' 和 'e' 被长按。
    //示例 2：
    //
    //输入：name = "saeed", typed = "ssaaedd"
    //输出：false
    //解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
    //示例 3：
    //
    //输入：name = "leelee", typed = "lleeelee"
    //输出：true
    //示例 4：
    //
    //输入：name = "laiden", typed = "laiden"
    //输出：true
    //解释：长按名字中的字符并不是必要的。
    //
    //
    //提示：
    //
    //name.length <= 1000
    //typed.length <= 1000
    //name 和 typed 的字符都是小写字母。
    //https://leetcode-cn.com/problems/long-pressed-name/
    public static void main(String[] args) {
        System.out.println(new LongPressedName925().isLongPressedName("alex", "aaleex"));
        System.out.println(new LongPressedName925().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new LongPressedName925().isLongPressedName("leelee", "lleeelee"));
        System.out.println(new LongPressedName925().isLongPressedName("laiden", "laiden"));
        System.out.println(new LongPressedName925().isLongPressedName("laidez", "laideccc"));
    }


    public boolean isLongPressedName(String name, String typed) {
        if(name.length()>typed.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)!=typed.charAt(j)){
                return false;
            }
            int nameCharCount = countChar(name, name.charAt(i), i);
            int typedCharCount = countChar(typed, typed.charAt(j), j);
            if(nameCharCount>typedCharCount){
                return false;
            }
            i+=nameCharCount;
            j+=typedCharCount;
        }
        return i==name.length() && j==typed.length();
    }

    public int countChar(String str, char x, int start){
        int count = 0;
        while(start<str.length()){
            if(str.charAt(start)==x){
                count++;
                start++;
            }else{
                break;
            }
        }
        return count;
    }

    public int[] sortArrayByParityII(int[] A) {
        int i = 0;//0,2,4,6...
        int j = 1;//1,3,5...
        while(i<A.length && j<A.length){
            while(i<A.length && A[i]%2==0){
                i+=2;
            }
            while(j<A.length && A[j]%2==1){
                j+=2;
            }
            if(i>=A.length || j>=A.length){
                return A;
            }else{
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
