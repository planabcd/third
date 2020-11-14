package string;

import java.util.*;

/**
 * @author think
 * @version v 1.0 2020/10/14 1:12
 */
public class FindCommonCharacters1002 {
    //1002. 查找常用字符
    //给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
    //
    //你可以按任意顺序返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：["bella","label","roller"]
    //输出：["e","l","l"]
    //示例 2：
    //
    //输入：["cool","lock","cook"]
    //输出：["c","o"]
    //
    //
    //提示：
    //
    //        1 <= A.length <= 100
    //        1 <= A[i].length <= 100
    //A[i][j] 是小写字母
    public static void main(String[] args) {
        List<String> strings = new FindCommonCharacters1002().commonChars(new String[]{"bella", "label", "roller"});
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A.length==0){
            return res;
        }
        int[] pre = new int[26];
        for (char c : A[0].toCharArray()) {
            pre[c-'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            int[] cur = new int[26];
            for (char aChar : chars) {
                cur[aChar-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                pre[j] = Math.min(pre[j], cur[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < pre[i]; j++) {
                res.add((char)(i+'a')+"");
            }
        }
        return res;
    }

}
