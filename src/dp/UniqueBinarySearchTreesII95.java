package dp;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/7/22 0:29
 */
public class UniqueBinarySearchTreesII95 {
    //95. 不同的二叉搜索树 II
    //给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
    //
    //
    //
    //示例：
    //
    //输入：3
    //输出：
    //        [
    //        [1,null,3,2],
    //        [3,2,null,1],
    //        [3,1,null,null,2],
    //        [2,1,3],
    //        [1,null,2,null,3]
    //        ]
    //解释：
    //以上的输出对应以下 5 种不同结构的二叉搜索树：
    //
    //        1         3     3      2      1
    //        \       /     /      / \      \
    //        3     2     1      1   3      2
    //        /     /       \                 \
    //        2     1         2                 3
    //
    //
    //提示：
    //
    //        0 <= n <= 8
    //https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> left = helper(start,i-1);
            List<TreeNode> right = helper(i+1,end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftNode;
                    cur.right = rightNode;
                    result.add(cur);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new UniqueBinarySearchTreesII95().minArray(new int[]{2,2,2,0,1});
        System.out.println(i);
    }

    public int minArray(int[] numbers) {
        //3,4,5,1,2
        if(numbers.length==0){
            return 0;
        }
        if(numbers.length==1){
            return numbers[0];
        }
        if(numbers[numbers.length-1]>numbers[0]){
            return numbers[0];
        }
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(numbers[mid]<numbers[right]){
                right = mid;
            }else if(numbers[mid]>numbers[right]){
                left = mid+1;
            }else{
                right = right-1;
            }
        }
        return numbers[left];
    }
}
