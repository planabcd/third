package string;

/**
 * @author think
 * @version v 1.0 2020/6/24 22:22
 */
public class PatternMatchingLcci {
    //面试题 16.18. 模式匹配
    //你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
    //
    //示例 1：
    //
    //输入： pattern = "abba", value = "dogcatcatdog"
    //输出： true
    //示例 2：
    //
    //输入： pattern = "abba", value = "dogcatcatfish"
    //输出： false
    //示例 3：
    //
    //输入： pattern = "aaaa", value = "dogcatcatdog"
    //输出： false
    //示例 4：
    //
    //输入： pattern = "abba", value = "dogdogdogdog"
    //输出： true
    //解释： "a"="dogdog",b=""，反之也符合规则
    //提示：
    //
    //        0 <= len(pattern) <= 1000
    //        0 <= len(value) <= 1000
    //你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
    //https://leetcode-cn.com/problems/pattern-matching-lcci/
    public static void main(String[] args) {
        System.out.println(new PatternMatchingLcci().patternMatching("bbb","xxxxxx"));
    }

    public boolean patternMatching(String pattern, String value) {
        //如果pattern为空,则value必须为空才能匹配
        if(pattern.length()==0){
            return value.length()==0;
        }
        int countA = 0;
        int countB = 0;
        for (char c : pattern.toCharArray()) {
            if(c!='a' && c!='b'){
                return false;
            }
            if(c=='a'){
                countA++;
            }else{
                countB++;
            }
        }
        if(value.length()==0){
            return countA==0 || countB==0;
        }
        //找到countA和countB中最大的一个来做枚举,比如countA比较大,则a对应的value字符串就短
        if(countA<countB){
            int temp = countA;
            countA = countB;
            countB = temp;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                if(pattern.charAt(i)=='a'){
                    str.append('b');
                }else{
                    str.append('a');
                }
            }
            pattern = str.toString();
        }
        //aaab->dogdogdogbot
        for (int lengthA = 0; countA*lengthA <= value.length(); lengthA++) {
            //枚举a字符串的长度,a对应字符串strA最短为0,最长为value.length/countA
            //int lengthB = (value.length()-lengthA*countA)/countB;
            int rest = value.length()-lengthA*countA;
            if(countB==0){
                if(rest!=0){
                    continue;
                }
            }else{
                if(rest%countB!=0){
                    continue;
                }
            }
            int lengthB = countB==0 ? 0: rest/countB;
            String strA = "";
            String strB = "";
            int index = 0;
            boolean correct = true;
            for (int i = 0; i < pattern.length(); i++) {
                if(pattern.charAt(i)=='a'){
                    if(strA.length()==0){
                        strA = value.substring(index,index+lengthA);
                    }else{
                        if(!strA.equals(value.substring(index,index+lengthA))){
                            correct = false;
                            break;
                        }
                    }
                    index = index+lengthA;
                }else{
                    if(strB.length()==0){
                        strB = value.substring(index, index+lengthB);
                    }else{
                        if(!strB.equals(value.substring(index,index+lengthB))){
                            correct = false;
                            break;
                        }
                    }
                    index = index+lengthB;
                }
            }
            if(correct && !strA.equals(strB)){
                return true;
            }
        }
        return false;
    }
}
