package greedy;

import java.util.Arrays;

/**
 * @author think
 * @version v 1.0 2019/12/1 18:01
 */
public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {10,9,7,8};
        int[] s = {5,6,7,8};
        int contentChildren = new AssignCookies().findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int sIndex = 0;
        int gIndex = 0;
        while(sIndex<s.length && gIndex<g.length){
            if(g[gIndex]<=s[sIndex]){
                res = g[gIndex];
                gIndex++;
                sIndex++;
            }else{
                sIndex++;
            }
        }
        return res;
    }
}
