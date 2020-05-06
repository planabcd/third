package string;

/**
 * @author think
 * @version v 1.0 2019/10/12 20:20
 */
public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Anagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        int[] map = new int[26];
        for(int i=0; i!=sarray.length; i++){
            map[sarray[i]-'a'] +=1;
        }
        for(int j=0; j!=tarray.length; j++){
            map[tarray[j]-'a'] -=1;
        }
        for(int k=0; k!=26; k++){
            if(map[k]!=0){
                return false;
            }
        }
        return true;
    }
}
