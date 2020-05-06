package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author think
 * @version v 1.0 2019/11/25 23:13
 */
public class NQueens51 {
    public static void main(String[] args) {
        List<List<String>> lists = new NQueens51().solveNQueens(8);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }

    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    Set<Integer> co = new HashSet<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n<1){
            return res;
        }
        helper2(n,0,temp,res);
        return res;
    }

    private void helper2(int n, int row, List<Integer> temp, List<List<String>> res) {
        if(n==row){
            print2(temp,res,n);
            return;
        }
        for (int col = 0; col < n; col++) {
            if(pie.contains(row+col) || na.contains(row-col) || co.contains(col)){
                continue;
            }
            pie.add(row+col);
            na.add(row-col);
            co.add(col);
            temp.add(col);
            helper2(n,row+1,temp,res);
            pie.remove(row+col);
            na.remove(row-col);
            co.remove(col);
            temp.remove(temp.size()-1);
        }
    }

    private void print2(List<Integer> temp, List<List<String>> res, int n) {
        List<String> rowList = new ArrayList<>();
        res.add(rowList);
        for (Integer integer : temp) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if(integer==i){
                    str.append("Q");
                }else{
                    str.append(".");
                }
            }
            rowList.add(str.toString());
        }

    }

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> pieSet = new HashSet<>();
        Set<Integer> naSet = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        helper(n, 0, temp, colSet, pieSet, naSet,res);
        return res;
    }

    private void print(int n, List<Integer> dfsRe, List<List<String>> res) {

        List<String> oneRes = new ArrayList<>();
        res.add(oneRes);
        for (Integer dfsR : dfsRe) {
            StringBuilder strB = new StringBuilder();
            for(int i=0; i!=n; i++){
                if(i==dfsR){
                    strB.append("Q");
                }else{
                    strB.append(".");
                }
            }
            oneRes.add(strB.toString());
        }
    }

    private void helper(int n, int row, List<Integer> temp, Set<Integer> colSet, Set<Integer> pieSet, Set<Integer> naSet, List<List<String>> res) {
        if (n == row) {
            print(n,temp,res );
            return;
        }
        for (int col = 0; col != n; col++) {
            if (colSet.contains(col) || pieSet.contains(row + col) || naSet.contains(row - col)) {
                continue;
            }
            colSet.add(col);
            pieSet.add(row + col);
            naSet.add(row - col);
            temp.add(col);
            helper(n, row + 1, temp, colSet, pieSet, naSet, res);
            colSet.remove(col);
            pieSet.remove(row + col);
            naSet.remove(row - col);
            temp.remove(temp.size()-1);
        }
    }
}
