package trie;

/**
 * @author think
 * @version v 1.0 2019/12/10 0:05
 */
public class ImplementTriePrefixTree208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }

    //实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
    //
    //示例:
    //
    //Trie trie = new Trie();
    //
    //trie.insert("apple");
    //trie.search("apple");   // 返回 true
    //trie.search("app");     // 返回 false
    //trie.startsWith("app"); // 返回 true
    //trie.insert("app");
    //trie.search("app");     // 返回 true
    //说明:
    //
    //你可以假设所有的输入都是由小写字母 a-z 构成的。
    //保证所有输入均为非空字符串。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    static class Trie {
        private Trie[] links;
        private boolean end;

        /** Initialize your data structure here. */
        public Trie() {
            links = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word.length()==0){
                return;
            }
            char[] chars = word.toCharArray();
            Trie root = this;
            for (char c : chars) {
                if(root.links[c - 'a']==null){
                    root.links[c-'a'] = new Trie();
                }
                root = root.links[c-'a'];
            }
            root.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if(word.length()==0){
                return false;
            }
            char[] chars = word.toCharArray();
            Trie root = this;
            for (char c : chars) {
                root = root.links[c - 'a'];
                if(root==null){
                    return false;
                }
            }
            if(root.end){
                return true;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(prefix.length()==0){
                return true;
            }
            char[] chars = prefix.toCharArray();
            Trie root = this;
            for (char c : chars) {
                root = root.links[c-'a'];
                if(root==null){
                    return false;
                }
            }
            return true;
        }
    }
}
