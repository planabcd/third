package dict;

import java.util.HashMap;

public class MaxLengthSubDifference {
    public static void main(String[] args) {
        int abba = lengthOfLongestSubstring("abba");

    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        //存的是字符最后一次开始的位置
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        int end = 0;
        int result = 0;
        int size = s.length();
        for(int i=0; i!=size; i++){
            char c = s.charAt(i);
            end = i;
            if(map.containsKey(c)){
                start = Math.max(start,map.get(c)+1);
            }
            map.put(c,i);
            result = Math.max(result,end-start+1);
        }
        return result;

    }
}
