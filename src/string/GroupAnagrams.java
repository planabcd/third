package string;

import java.util.*;

/**
 * @author think
 * @version v 1.0 2019/10/30 23:34
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs==null || strs.length==0){
            return result;
        }
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        int[] counts = new int[26];
        for(String str : strs){
            Arrays.fill(counts,0);
            for(char c : str.toCharArray()){
                counts[c-'a']+=1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i!=26; i++){
                stringBuilder.append("#");
                stringBuilder.append(counts[i]);
            }
            List<String> strings = map.get(stringBuilder.toString());
            if(strings==null){
                strings = new ArrayList<String>();
                map.put(stringBuilder.toString(),strings);
            }
            strings.add(str);
        }
        for(List<String> value : map.values()){
            result.add(value);
        }
        return result;
    }

}
