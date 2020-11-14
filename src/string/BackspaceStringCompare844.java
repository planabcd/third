package string;

import java.util.Stack;

/**
 * @author think
 * @version v 1.0 2020/10/19 0:37
 */
public class BackspaceStringCompare844 {
    //844. 比较含退格的字符串
    //给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
    //
    //注意：如果对空文本输入退格字符，文本继续为空。
    //
    //
    //
    //示例 1：
    //
    //输入：S = "ab#c", T = "ad#c"
    //输出：true
    //解释：S 和 T 都会变成 “ac”。
    //示例 2：
    //
    //输入：S = "ab##", T = "c#d#"
    //输出：true
    //解释：S 和 T 都会变成 “”。
    //示例 3：
    //
    //输入：S = "a##c", T = "#a#c"
    //输出：true
    //解释：S 和 T 都会变成 “c”。
    //示例 4：
    //
    //输入：S = "a#c", T = "b"
    //输出：false
    //解释：S 会变成 “c”，但 T 仍然是 “b”。
    //
    //
    //提示：
    //
    //        1 <= S.length <= 200
    //        1 <= T.length <= 200
    //S 和 T 只含有小写字母以及字符 '#'。
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare844().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new BackspaceStringCompare844().backspaceCompare("a##c", "#a#c"));
        System.out.println(new BackspaceStringCompare844().backspaceCompare("a#c", "b"));
    }
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        for (char sChar : sChars) {
            if(sChar=='#'){
                if(!sStack.isEmpty()){
                    sStack.pop();
                }
            }else{
                sStack.push(sChar);
            }
        }
        for (char tChar : tChars) {
            if(tChar=='#'){
                if(!tStack.isEmpty()){
                    tStack.pop();
                }
            }else{
                tStack.push(tChar);
            }
        }
        if (sStack.size() != tStack.size()) {
            return false;
        }
        if(sStack.isEmpty()){
            return true;
        }
        while(!sStack.isEmpty()){
            if(sStack.pop()!=tStack.pop()){
                return false;
            }
        }
        return true;

    }
}
