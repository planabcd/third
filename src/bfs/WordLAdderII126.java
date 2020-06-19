package bfs;

import java.util.*;

/**
 * @author think
 * @version v 1.0 2019/11/27 0:18
 */
public class WordLAdderII126 {
    //126. 单词接龙 II
    //给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
    //
    //每次转换只能改变一个字母。
    //转换过程中的中间单词必须是字典中的单词。
    //说明:
    //
    //如果不存在这样的转换序列，返回一个空列表。
    //所有单词具有相同的长度。
    //所有单词只由小写字母组成。
    //字典中不存在重复的单词。
    //你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    //示例 1:
    //
    //输入:
    //beginWord = "hit",
    //endWord = "cog",
    //wordList = ["hot","dot","dog","lot","log","cog"]
    //
    //输出:
    //        [
    //        ["hit","hot","dot","dog","cog"],
    //        ["hit","hot","lot","log","cog"]
    //        ]
    //示例 2:
    //
    //输入:
    //beginWord = "hit"
    //endWord = "cog"
    //wordList = ["hot","dot","dog","lot","log"]
    //
    //输出: []
    //
    //解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
    //https://leetcode-cn.com/problems/word-ladder-ii/
    public static void main(String[] args) {
        String[] wordArray = {"ted","tex","red","tax","tad","den","rex","pee"};
        List<String> wordList = Arrays.asList(wordArray);
        //Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new WordLAdderII126().findLadders("red", "tax", wordList);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }
        //List<String> neiberWords = new WordLAdderII126().getNeiberWord("dot", 3, wordSet);
        //for (String neiberWord : neiberWords) {
        //    System.out.print(neiberWord+"\t");
        //}
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList.size()==0 || !wordList.contains(endWord)){
            return res;
        }
        //对原始输入去重
        Set<String> wordSet = new HashSet<>(wordList);
        //存储单词->后继单词list
        Map<String,Set<String>> map = new HashMap<>();
        //bfs找到 每个单词的后继单词
        //1.一个单词不能和同一层的单词有关系,在同一层左右拐弯再往下一层走肯定比直接往下一层走的路程要长
        //2.如果当前层的某个单词已经匹配到endWord还不能停下来,同一层可能有多个单词都可以通向endWord
        boolean isFound = bfs(beginWord,endWord,wordSet,map);
        if(!isFound){
            return res;
        }
        //遍历bfs等到的word->后继list,得到的路径就是所有的最短路径
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord,endWord,map,res,path);
        return res;
    }


    private boolean bfs(String beginWord, String endWord,Set<String> wordSet, Map<String,Set<String>> map) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> allVisited = new HashSet<>();
        Set<String> levelVisted = new HashSet<>();
        allVisited.add(beginWord);
        int length = beginWord.length();
        boolean isFound = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                List<String> neiberWords = getNeiberWord(poll, length, wordSet);
                for (String neiberWord : neiberWords) {
                    if(allVisited.contains(neiberWord)){
                        continue;
                    }
                    //if(levelVisted.contains(neiberWord)){
                    //    System.out.print(neiberWord+":");
                    //    for (String s : levelVisted) {
                    //        System.out.print(s+"\t");
                    //    }
                    //    System.out.println();
                    //    continue;
                    //}
                    if(neiberWord.equals(endWord)){
                        isFound = true;
                    }
                    levelVisted.add(neiberWord);
                    Set<String> set = map.computeIfAbsent(poll, k -> new HashSet<>());
                    set.add(neiberWord);
                    queue.offer(neiberWord);
                }
            }
            if(isFound){
                break;
            }
            allVisited.addAll(levelVisted);
            levelVisted.clear();
        }
        return isFound;
    }

    private List<String> getNeiberWord(String beginWord, int wordLength, Set<String> wordSet){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            char[] originChars = beginWord.toCharArray();
            char originChar = originChars[i];
            for (int j = 'a'; j <='z'; j++) {
                if(originChar == j){
                    continue;
                }
                originChars[i] = (char) j;
                String newWord = new String(originChars);
                if(wordSet.contains(newWord)){
                    res.add(newWord);
                }
            }
            originChars[i] = originChar;
        }
        return res;
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> map, List<List<String>> res, List<String> path) {
        if(beginWord.equals(endWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        Set<String> nextWords = map.get(beginWord);
        if(nextWords==null){
            return;
        }
        for (String nextWord : nextWords) {
            path.add(nextWord);
            dfs(nextWord, endWord, map, res, path);
            path.remove(path.size()-1);
        }
    }
}
