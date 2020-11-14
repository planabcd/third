package tree;

import java.util.ArrayList;

/**
 * @author think
 * @version v 1.0 2020/9/26 13:46
 */
public class FindModeInBinarySearchTree501 {
    //501. 二叉搜索树中的众数
    //给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
    //
    //假定 BST 有如下定义：
    //
    //结点左子树中所含结点的值小于等于当前结点的值
    //        结点右子树中所含结点的值大于等于当前结点的值
    //左子树和右子树都是二叉搜索树
    //例如：
    //给定 BST [1,null,2,2],
    //
    //        1
    //        \
    //        2
    //        /
    //        2
    //返回[2].
    //
    //提示：如果众数超过1个，不需考虑输出顺序
    //
    //进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
    //https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/

    ArrayList<Integer> list;
    int count;
    int maxCount;
    int base;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        helper(root);
        int[] res = new int[list.size()];
        for (int i = 0; i !=list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void helper(TreeNode root) {
        if(root==null){
            return;
        }
        helper(root.left);
        update(root.val);
        helper(root.right);
    }

    private void update(int val) {
        if(base==val){
            count++;
        }else{
            base = val;
            count = 1;
        }
        if(count==maxCount){
            list.add(base);
        }
        if(count>maxCount){
            list.clear();
            maxCount = count;
            list.add(base);
        }
    }


}
