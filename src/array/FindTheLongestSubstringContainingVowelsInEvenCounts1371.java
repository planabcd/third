package array;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2020/5/21 1:20
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts1371 {
    //1371. 每个元音包含偶数次的最长子字符串
    //给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "eleetminicoworoep"
    //输出：13
    //解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
    //示例 2：
    //
    //输入：s = "leetcodeisgreat"
    //输出：5
    //解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
    //示例 3：
    //
    //输入：s = "bcbcbc"
    //输出：6
    //解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
    //https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
    public int findTheLongestSubstring(String s) {
        //5位二进制数表示个状态,10010 表示 a出现奇数次,o出现奇数次
        //p[i]表示s[0,i]的元音状态
        //p[i]如果和p[j]状态相同,那么s[0,i]和s[0,j]状态相同
        //s[i+1,j]必定拥有偶数个元音
        //这道题转换为求在p[i]和p[j]相同的情况下,j-(i+1)+1的最大值
        int[] pre = new int[32];
        Arrays.fill(pre,-1);
        pre[0] = 0;
        int status = 0;
        int  result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='a'){
                status ^= (1<<0);
            }
            if(ch=='e'){
                status ^= (1<<1);
            }
            if(ch=='i'){
                status ^= (1<<2);
            }
            if(ch=='o'){
                status ^= (1<<3);
            }
            if(ch=='u'){
                status ^= (1<<4);
            }
            if(pre[status]==-1){
                pre[status]=i+1;
            }else{
                result = Math.max(result,i+1-pre[status]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(new FindTheLongestSubstringContainingVowelsInEvenCounts1371().findTheLongestSubstring("eleetminicoworoep"));
    }
}
