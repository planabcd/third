package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/27 0:18
 */
public class WordLAdderII126 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        List<List<String>> ladders = new WordLAdderII126().findLadders("hit", "cog", list);
        for (List<String> ladder : ladders) {
            for (String s : ladder) {
                System.out.println(s+"\t");
            }
            System.out.println(ladder);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
            return res;
        }
        if (!wordList.contains(endWord)) {
            return res;
        }
        return res;
    }


}
