package bfs;

import java.util.LinkedList;

/**
 * @author think
 * @version v 1.0 2019/11/26 23:31
 */
public class MinimumGeneticMutation433 {
    public static void main(String[] args) {
        int result = new MinimumGeneticMutation433().minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"});
        System.out.println(result);
    }

    public int minMutation(String start, String end, String[] bank) {
        if(bank.length==0 || start.length()==0 || end.length()==0){
            return -1;
        }
        //boolean exist = false;
        //for (String s : bank) {
        //    if(s.equals(end)){
        //       exist = true;
        //       break;
        //    }
        //}
        //if(!exist){
        //    return -1;
        //}
        LinkedList<String> queue = new LinkedList<>();
        boolean[] used = new boolean[bank.length];
        int level = 0;
        queue.offer(start);
        int wordLength = start.length();
        while(queue.size()!=0){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    if(used[j]){
                        continue;
                    }
                    String bankWord = bank[j];
                    int diff = 0;
                    for (int k = 0; k < wordLength; k++) {
                        if(bankWord.charAt(k)!=poll.charAt(k)){
                            diff++;
                            if(diff>1){
                                break;
                            }
                        }
                    }
                    if(diff==1){
                        if(bankWord.equals(end)){
                            return level;
                        }
                        used[j] = true;
                        queue.offer(bankWord);
                    }
                }
            }
        }
        return -1;
    }

    public int minMutation0(String start, String end, String[] bank) {
        if(bank.length==0 || start.length()==0 || end.length()==0){
            return -1;
        }
        LinkedList<String> queue = new LinkedList<>();
        boolean[] used = new boolean[bank.length];
        int level = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0; i!=size; i++){
                String poll = queue.poll();
                for(int j=0; j!=bank.length; j++){
                    if(used[j]){
                        continue;
                    }
                    String nextStr = bank[j];
                    int diff = 0;
                    for(int z=0; z!=nextStr.length(); z++){
                        if(nextStr.charAt(z)!=poll.charAt(z)){
                            diff++;
                        }
                    }
                    if(diff==1){
                        if(nextStr.equals(end)){
                            return level;
                        }
                        queue.offer(nextStr);
                        used[j] = true;
                    }
                }
            }
        }
        return -1;
    }
}
