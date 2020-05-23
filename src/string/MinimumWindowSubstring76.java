package string;

/**
 * @author think
 * @version v 1.0 2020/5/23 14:15
 */
public class MinimumWindowSubstring76 {
    //76. 最小覆盖子串
    //给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
    //
    //示例：
    //
    //输入: S = "ADOBECODEBANC", T = "ABC"
    //输出: "BANC"
    //说明：
    //
    //如果 S 中不存这样的子串，则返回空字符串 ""。
    //如果 S 中存在这样的子串，我们保证它是唯一的答案。
    //https://leetcode-cn.com/problems/minimum-window-substring/
    public static void main(String[] args) {
        //System.out.println(new MinimumWindowSubstring76().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring76().minWindow("aa", "aa"));
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length()<t.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        // window中包含的t的字符个数,比如t=abc, window[left,right)  = abbdd,则count=2
        int count = 0;
        //一个滑动窗口window[left,right)  windows['a'] = 1表示在window[left,right)中'a'出现了一次
        int[] windows = new int[128];
        // 一个t拆解出来的字典needs
        int[] needs = new int[128];
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }
        //符合条件的最小子串长度
        int length = s.length() + 1;
        //符合条件的最小子串长度的leftIndex
        int start = 0;
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            right++;
            windows[rightCh] += 1;
            if (needs[rightCh] > 0 && windows[rightCh] <= needs[rightCh]) {
                //windows[rightCh] <= needs[rightCh] 含义解释
                //在减小滑动窗口时用的是t.length()==count,比如说t="aa",windows[left,right)碰到一次'a'就应该做一次加法,直到windows中包含了两个以上的a
                count++;
            }
            while (t.length() == count) {
                //如果windows[left,right)中包含的字符一直符合题意
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }
                char leftCh = s.charAt(left);
                left++;
                if (needs[leftCh] > 0 && windows[leftCh] <= needs[leftCh]) {
                    count--;
                }
                windows[leftCh] -= 1;
            }
        }
        return length == s.length() + 1 ? "" : s.substring(start, length + start);
    }

    public String minWindow2(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length()<t.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        // window中包含的t的字符个数,比如t=abc, window[left,right)  = abbdd,则count=2
        int count = 0;
        //一个滑动窗口window[left,right)  windows['a'] = 1表示在window[left,right)中'a'出现了一次
        int[] windows = new int[128];
        // 一个t拆解出来的字典needs
        int[] needs = new int[128];
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }
        //符合条件的最小子串长度
        int length = s.length() + 1;
        //符合条件的最小子串长度的leftIndex
        int start = 0;
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            right++;
            if (needs[rightCh] > 0) {
                windows[rightCh] += 1;
                if (windows[rightCh] == needs[rightCh]) {
                    count++;
                }
            }
            while (t.length() == count) {
                //如果windows[left,right)中包含的字符一直符合题意
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }
                char leftCh = s.charAt(left);
                left++;
                if (needs[leftCh] > 0) {
                    if (windows[leftCh] == needs[leftCh]) {
                        count--;
                    }
                    windows[leftCh] -= 1;
                }
            }
        }
        return length == s.length() + 1 ? "" : s.substring(start, length + start);
    }
}
