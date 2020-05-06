package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/19 23:32
 */
public class GenerateParentheses22 {

    List<String> list;
    public static void main(String[] args) {
        final List<String> strings = new GenerateParentheses22().generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n==0){
            return res;
        }
        int left = 0;
        int right = 0;
        helper(n,left,right,"",res);
        return res;
    }

    private void helper(int n, int left, int right, String s, List<String> res) {
        if(n==left && n==right){
            res.add(s);
            return;
        }
        if(left<n){
            helper(n,left+1,right,s+"(",res);
        }
        if(right<left){
            helper(n,left,right+1,s+")",res);
        }
    }


    public List<String> generateParenthesis2(int n) {
        list = new ArrayList<String>();
        generate(0,0,n,"");
        return list;
    }

    private void generate(int left, int right, int n, String s) {
        if(left==n && right==n){
            list.add(s);
            return;
        }
        if(left <n){
            generate(left+1,right,n,s+"(");
        }
        if(left>right){
            generate(left,right+1,n,s+")");
        }
    }
}
