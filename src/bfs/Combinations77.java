package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/23 15:30
 */
public class Combinations77 {
    public static void main(String[] args) {
        final List<List<Integer>> combine = new Combinations77().combine2(4, 2);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }

    //解法一:C(n,k) = C(n-1,k-1)+C(n-1,k)
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0 || k<=0 || n<k){
            return new ArrayList<List<Integer>>();
        }
        return helperCombine(n,k);
    }


    public List<List<Integer>> helperCombine(int n, int k) {
        if(k==0){
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }
        if(n==k){
            List<Integer> integers = new ArrayList<Integer>();
            for (int i = 1; i<=n; i++) {
                integers.add(i);
            }
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(integers);
            return result;
        }
        List<List<Integer>> result1 = helperCombine(n - 1, k - 1);
        for (int i = 0; i !=result1.size(); i++) {
            result1.get(i).add(n);
        }
        List<List<Integer>> result2 = helperCombine(n - 1, k);
        result1.addAll(result2);
        return result1;
    }

    //解法2
    public List<List<Integer>> combine2(int n, int k) {
        if(n<=0 || k<=0 || n<k){
            return new ArrayList<List<Integer>>();
        }
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        helperCombine2(n,k,1,tempList,result);
        return result;
    }

    private void helperCombine2(int n, int k, int start, List<Integer> tempList, List<List<Integer>> result) {
        if(k==tempList.size()){
            ArrayList<Integer> integers = new ArrayList<Integer>(tempList);
            result.add(integers);
            return;
        }
        for(int i=start; i<=n-(k-tempList.size())+1; i++){
            tempList.add(i);
            helperCombine2(n,k,i+1,tempList,result);
            tempList.remove(tempList.size()-1);
        }
    }


}
