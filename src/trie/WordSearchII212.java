package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author think
 * @version v 1.0 2019/12/10 0:39
 */
public class WordSearchII212 {

    public static void main(String[] args) {
        //String[] words = {"oath", "pea", "eat", "rain"};
        //char[][] board = {
        //        {'o', 'a', 'a', 'n'},
        //        {'e', 't', 'a', 'e'},
        //        {'i', 'h', 'k', 'r'},
        //        {'i', 'f', 'l', 'v'}
        //};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        char[][] board = {
                {'a', 'b'},
                {'a', 'a'},
        };
        List<String> res = new WordSearchII212().findWords(board, words);
        for (String re : res) {
            System.out.print(re+"\t");
        }
    }

    //    给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
    //
    //    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
    //
    //    示例:
    //
    //    输入:
    //    words = ["oath","pea","eat","rain"] and board =
    //[
    //        ['o','a','a','n'],
    //        ['e','t','a','e'],
    //        ['i','h','k','r'],
    //        ['i','f','l','v']
    //        ]
    //
    //    输出: ["eat","oath"]
    //    说明:
    //    你可以假设所有输入都由小写字母 a-z 组成。
    //
    //    提示:
    //
    //    你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
    //    如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
    //
    //    来源：力扣（LeetCode）
    //    链接：https://leetcode-cn.com/problems/word-search-ii
    //    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        //构造前缀树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        //dfs
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        //boolean[][] used =  new boolean[board.length][board[0].length];
        Set<String> resSet = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(row, col, "", resSet, trie, board, /*used,*/dx, dy);
            }
        }
        res.addAll(resSet);
        return res;
    }


    private void dfs(int row, int col,String temp, Set<String> res,Trie link, char[][] board, /*boolean[][] used,*/int[] dx, int[] dy) {
        char cur = board[row][col];
        link = link.links[cur - 'a'];
        if(link==null){
            return;
        }
        temp+=cur;
        if(link.end){
            res.add(temp);
        }
        char pre = board[row][col];
        board[row][col] = '#';
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(newRow>=0 && newRow<board.length && newCol>=0 && newCol<board[0].length){
                if(board[newRow][newCol]!='#'){
                    dfs(newRow, newCol,temp, res, link, board,/*used, */dx, dy);
                }
            }
        }
        board[row][col] = pre;
    }

    static class Trie {
        private Trie[] links;
        private boolean end;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            links = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word.length() == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            Trie root = this;
            for (char c : chars) {
                if (root.links[c - 'a'] == null) {
                    root.links[c - 'a'] = new Trie();
                }
                root = root.links[c - 'a'];
            }
            root.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word.length() == 0) {
                return false;
            }
            char[] chars = word.toCharArray();
            Trie root = this;
            for (char c : chars) {
                root = root.links[c - 'a'];
                if (root == null) {
                    return false;
                }
            }
            if (root.end) {
                return true;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) {
                return true;
            }
            char[] chars = prefix.toCharArray();
            Trie root = this;
            for (char c : chars) {
                root = root.links[c - 'a'];
                if (root == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
