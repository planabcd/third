package bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/24 8:52
 */
public class LetterCombinationOfAPhoneNumber17 {

    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //
    //
    //
    //示例:
    //
    //输入："23"
    //输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    //说明:
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number

    public static void main(String[] args) {
        List<String> result = new LetterCombinationOfAPhoneNumber17().letterCombinations("234");
        System.out.println(result);
    }



    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.length()==0){
            return res;
        }
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int firstNum = digits.charAt(0) - '0';
        String firstString = map[firstNum];
        for (int i = 0; i < firstString.length(); i++) {
            res.offer(firstString.charAt(i)+"");
        }
        for (int i = 1; i < digits.length(); i++) {
            int numIndex = digits.charAt(i) - '0';
            String numString = map[numIndex];
            while(res.getFirst().length()==i){
                String peek = res.removeFirst();
                for (int j = 0; j < numString.length(); j++) {
                    res.offer(peek+numString.charAt(j));
                }
            }
        }
        return res;
    }
}
