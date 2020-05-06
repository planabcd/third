package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liaoxin
 * @version v 1.0 2020/2/10 0:06
 */
public class WordBreak139 {
    //给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
    //
    //说明：
    //
    //拆分时可以重复使用字典中的单词。
    //你可以假设字典中没有重复的单词。
    //示例 1：
    //
    //输入: s = "leetcode", wordDict = ["leet", "code"]
    //输出: true
    //解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
    //示例 2：
    //
    //输入: s = "applepenapple", wordDict = ["apple", "pen"]
    //输出: true
    //解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
    //             注意你可以重复使用字典中的单词。
    //示例 3：
    //
    //输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    //输出: false
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/word-break
    public static void main(String[] args) {
        List<String> dictList = new ArrayList<String>();
        dictList.add("leet");
        dictList.add("code");
        System.out.println(new WordBreak139().wordBreak("leetcode",dictList));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0){
            return true;
        }
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        //dp[i] = true表示以i结尾的字符可以由wordDict里的单词组成
        boolean[] dp = new boolean[s.length()];
        for (int right = 0; right < s.length(); right++) {
            if(wordSet.contains(s.substring(0,right+1))){
                dp[right] = true;
                continue;
            }
            for (int left = 0; left < right; left++) {
                if(dp[left] && wordSet.contains(s.substring(left+1,right+1))){
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
