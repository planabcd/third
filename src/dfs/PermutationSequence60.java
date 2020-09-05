package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/9/5 8:42
 */
public class PermutationSequence60 {
    //60. 第k个排列
    //给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
    //
    //按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
    //
    //        "123"
    //        "132"
    //        "213"
    //        "231"
    //        "312"
    //        "321"
    //给定 n 和 k，返回第 k 个排列。
    //
    //说明：
    //
    //给定 n 的范围是 [1, 9]。
    //给定 k 的范围是[1,  n!]。
    //示例 1:
    //
    //输入: n = 3, k = 3
    //输出: "213"
    //示例 2:
    //
    //输入: n = 4, k = 9
    //输出: "2314"
    //https://leetcode-cn.com/problems/permutation-sequence/
    public static void main(String[] args) {
        System.out.println(new PermutationSequence60().getPermutation(3,3));
        System.out.println(new PermutationSequence60().getPermutation(4,9));
    }

    public String getPermutation(int n, int k) {
        //阶乘
        int total = 1;
        //候选项,会一个一个慢慢减少到0为止
        //[1,2,3]
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i<=n; i++) {
            nums.add(i);
            total *= i;
        }
        StringBuilder str = new StringBuilder();
        //索引从0开始,方便计算取模的groupIndex
        k--;
        //123,132是第一组,213,231是第二组,312,321是第三组
        while (nums.size()>0){
            //组的数量是 nums.size()
            //每一组的数量是 total/nums.size()
            //第k个数落到第几组(从0开始),比如第2个是落到第0组
            int groupNum = nums.size();
            int perGroupNum = total/groupNum;
            int groupIndex = k/perGroupNum;
            str.append(nums.get(groupIndex));
            nums.remove(groupIndex);
            total = total/groupNum;
            k = k % total;
        }
        return str.toString();
    }



        String res = null;
    int th = 1;
    int k = 0;
    public String getPermutation2(int n, int k) {
        if(k<=0){
            return res;
        }
        boolean[] used = new boolean[n];
        this.k = k;
        helper(n,0,used, new ArrayList<>());
        return res;
    }

    private void helper(int n, int start, boolean[] used, List<Integer> temp) {
        if(n==start){
            if(th++==k){
                StringBuilder str = new StringBuilder();
                for (Integer integer : temp) {
                    str.append(integer);
                }
                res = str.toString();
            }
            return;
        }
        if(res!=null){
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!used[i-1]){
                used[i-1] = true;
                temp.add(i);
                helper(n, start+1, used, temp);
                temp.remove(temp.size()-1);
                used[i-1] = false;
            }
        }
    }
}
