package bfs;

import java.util.*;

/**
 * @author think
 * @version v 1.0 2019/11/27 0:18
 */
public class WordLAdder127 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        int i = new WordLAdder127().ladderLength("hit", "cog", list);
        System.out.println(i);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        LinkedList<String> begin = new LinkedList<>();
        LinkedList<String> end = new LinkedList<>();
        begin.offer(beginWord);
        end.offer(endWord);
        int wordLength = wordList.get(0).length();
        Map<String,List<String>> wordMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < wordLength; j++) {
                String newWord = word.substring(0,j)+"*"+word.substring(j+1,wordLength);
                List<String> list = wordMap.get(newWord);
                if(list==null){
                    list = new ArrayList<>();
                    wordMap.put(newWord,list);
                }
                list.add(word);
            }
        }

        int level = 1;
        Set<String> used = new HashSet<>();
        while(begin.size()!=0 && end.size()!=0){
            if(begin.size()>end.size()){
                LinkedList<String> temp = begin;
                begin = end;
                end = temp;
            }
            int size = begin.size();
            LinkedList<String> next = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                String queueWord = begin.get(i);
                for (int j = 0; j < wordLength; j++) {
                    String newWord = queueWord.substring(0,j)+"*"+queueWord.substring(j+1,wordLength);
                    List<String> list = wordMap.get(newWord);
                    if(list==null){
                        continue;
                    }
                    for (String word : list) {
                        if(end.contains(word)){
                            return level+1;
                        }
                        if(used.contains(word)){
                            continue;
                        }
                        used.add(word);
                        next.add(word);
                    }
                }
            }
            begin = next;
            level++;
        }
        return 0;
    }

    public int ladderLength0(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        boolean[] used = new boolean[wordList.size()];
        int level = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i != size; i++) {
                String poll = queue.poll();
                System.out.println(poll);
                for (int j = 0; j != wordList.size(); j++) {
                    if (used[j]) {
                        continue;
                    }
                    String nextWord = wordList.get(j);
                    int diff = 0;
                    for (int z = 0; z != nextWord.length(); z++) {
                        if (nextWord.charAt(z) != poll.charAt(z)) {
                            diff++;
                        }
                        if(diff==2){
                            break;
                        }
                    }
                    if (diff == 1) {
                        if (nextWord.equals(endWord)) {
                            level++;
                            return level;
                        }
                        used[j] = true;
                        queue.offer(nextWord);
                    }
                }
            }
        }
        return 0;
    }

    class Level {
        String s;
        int level;

        Level(String s, int level) {
            this.s = s;
            this.level = level;
        }
    }

    //解法二
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
            return 0;
        }
        Map<String, List<String>> newWord2List = new HashMap<>();
        int wordLength = beginWord.length();
        for (String s : wordList) {
            for (int i = 0; i != wordLength; i++) {
                String key = s.substring(0, i) + "*" + s.substring(i + 1, wordLength);
                if (!newWord2List.containsKey(key)) {
                    newWord2List.put(key, new ArrayList<String>());
                }
                newWord2List.get(key).add(s);
            }
        }
        Queue<Level> queue = new LinkedList<>();
        queue.offer(new Level(beginWord, 1));
        Map<String, Boolean> usedMap = new HashMap<>();
        while (!queue.isEmpty()) {
            Level pollLevel = queue.poll();
            String poll = pollLevel.s;
            System.out.println(poll);
            for (int i = 0; i != wordLength; i++) {
                String key = poll.substring(0, i) + "*" + poll.substring(i + 1, wordLength);
                List<String> chooseList = newWord2List.get(key);
                if (chooseList == null) {
                    chooseList = new ArrayList<>();
                }
                for (int j = 0; j != chooseList.size(); j++) {
                    String s = chooseList.get(j);
                    if (endWord.equals(s)) {
                        return pollLevel.level + 1;
                    } else {
                        if (!usedMap.containsKey(s)) {
                            usedMap.put(s, true);
                            queue.offer(new Level(s, pollLevel.level + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    //解法三
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> newWord2List = new HashMap<>();
        int wordLength = beginWord.length();
        for (String s : wordList) {
            for (int i = 0; i != wordLength; i++) {
                String key = s.substring(0, i) + "*" + s.substring(i + 1, wordLength);
                if (!newWord2List.containsKey(key)) {
                    newWord2List.put(key, new ArrayList<String>());
                }
                newWord2List.get(key).add(s);
            }
        }

        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        beginQueue.offer(beginWord);
        endQueue.offer(endWord);
        Set<String> usedSet = new HashSet<>();
        int level = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() > endQueue.size()) {
                Queue<String> temp = endQueue;
                endQueue = beginQueue;
                beginQueue = temp;
            }
            Queue<String> nextQueue = new LinkedList<>();
            for (String poll : beginQueue) {
                for (int i = 0; i != wordLength; i++) {
                    String key = poll.substring(0, i) + "*" + poll.substring(i + 1, wordLength);
                    if (!newWord2List.containsKey(key)) {
                        continue;
                    }
                    List<String> newWordList = newWord2List.get(key);
                    for (String s : newWordList) {
                        if (endQueue.contains(s)) {
                            return level + 1;
                        }
                        if (!usedSet.contains(s)) {
                            usedSet.add(s);
                            nextQueue.offer(s);
                        }
                    }
                }
            }
            beginQueue = nextQueue;
            level++;
        }
        return 0;
    }

    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        //endWord也是transformed word, 所以必须存在于wordList中, 否则返回0, 表示无法从beginWord变成endWord
        if (!wordList.contains(endWord)) {
            return 0;
        }
        //
        int n = beginWord.length();
        //key是通用状态; value是拥有该通用状态的词
        HashMap<String, ArrayList<String>> all_commons = new HashMap<>();
        //记录wordList中所有元素对应的所有通用状态
        for (String s : wordList) {
            for (int i = 0; i != n; i++) {
                String key = s.substring(0, i) + "*" + s.substring(i + 1, n);
                if (!all_commons.containsKey(key)) {
                    all_commons.put(key, new ArrayList<String>());
                }
                all_commons.get(key).add(s);
            }
        }
        //使用HashSet实现宽度优先遍历bfs
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        //记录访问过的节点
        HashSet<String> visited = new HashSet<>();
        //细节: 返回值的初始化, 由于beginWord!=endWord, 所以至少需要一步变化
        int len = 1;
        while (!begin.isEmpty() && !end.isEmpty()) {
            //核心:控制当前循环从哪个方向进行bfs; 让begin指向size更小的集合, 这样就不会一直从一个方向bfs了
            if (begin.size() > end.size()) {
                HashSet<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            //记录遍历begin时每个元素的邻居, 也就是cur的邻居
            HashSet<String> neighbor = new HashSet<>();
            for (String cur : begin) {
                //遍历cur的邻居
                for (int i = 0; i < n; i++) {
                    String tmp = cur.substring(0, i) + "*" + cur.substring(i + 1);
                    //有了all_commons哈希表,就不用每个位置都遍历'a'~'z'了
                    //细节:如果cur是beginWord的话, all_commons没有统计beginWord的通用状态, 所以all_commons.get(tmp)可能返回null, 所以要提前检查一下
                    if (!all_commons.containsKey(tmp)) {
                        continue;
                    }
                    for (String str : all_commons.get(tmp)) {
                        if (end.contains(str)) {
                            return len + 1;
                        }
                        if (!visited.contains(str)) {
                            visited.add(str);
                            //记录cur的邻居
                            neighbor.add(str);
                        }
                    }
                }
            }
            //处理完begin中的元素后, 让begin指向begin中的元素的邻居
            begin = neighbor;
            //路径长度++
            len++;
        }
        //执行到这里说明双向bfs没有相遇, 也就是没有找到从beginWord到endWord的路径
        return 0;
    }
}
