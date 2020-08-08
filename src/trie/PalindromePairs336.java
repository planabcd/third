package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/8/8 18:00
 */
public class PalindromePairs336 {
    //336. 回文对
    //给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
    //
    //
    //
    //示例 1：
    //
    //输入：["abcd","dcba","lls","s","sssll"]
    //输出：[[0,1],[1,0],[3,2],[2,4]]
    //解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
    //示例 2：
    //
    //输入：["bat","tab","cat"]
    //输出：[[0,1],[1,0]]
    //解释：可拼接成的回文串为 ["battab","tabbat"]
    //https://leetcode-cn.com/problems/palindrome-pairs/
    public static void main(String[] args) {
        PalindromePairs336 palindromePairs336 = new PalindromePairs336();
        List<List<Integer>> result = palindromePairs336.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i],i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j <= wordLength; j++) {
                //j最大值为wordLength的原因是可能word原字符串需要和目标串逆序,word.substring(0,j.max)=word
                if(isPalindrome(word,j, wordLength -1)){
                    //word[j:]是一个回文串,words中能找到word[0:j-1]的反转,则word和目标串可以组成回文串
                    int wordIndex = trie.findIndex(word.substring(0,j));
                    if(wordIndex!=-1 && wordIndex!=i){
                        List<Integer> row = new ArrayList<>();
                        row.add(i);
                        row.add(wordIndex);
                        result.add(row);
                    }
                }
                //回文串的范围是word[0,wordLength-1]
                if(j!=0 && isPalindrome(word,0,j-1)){
                    int wordIndex = trie.findIndex(word.substring(j, wordLength));
                    if(wordIndex!=-1 && wordIndex!=i){
                        List<Integer> row = new ArrayList<>();
                        row.add(wordIndex);
                        row.add(i);
                        result.add(row);
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String str, int i, int j){
        if(i>=j){
            return true;
        }
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    class Trie{
        Trie[] root;
        boolean isEnd;
        int index;
        public Trie(){
            root = new Trie[26];
            index = -1;
        }

        public void insert(String str, int index){
            Trie temp = this;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                int cur = str.charAt(i) - 'a';
                if(temp.root[cur]==null){
                    temp.root[cur] = new Trie();
                }
                temp = temp.root[cur];
            }
            temp.isEnd = true;
            temp.index = index;
        }

        public int findIndex(String str){
            int length = str.length();
            Trie temp = this;
            //正序存入,逆序寻找
            for (int i = length-1; i >=0; i--) {
                int cur = str.charAt(i)-'a';
                if(temp.root[cur]==null){
                    return -1;
                }
                temp = temp.root[cur];
            }
            if(temp.isEnd){
                return temp.index;
            }
            return -1;
        }
    }
}
