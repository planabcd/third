package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/8/8 23:08
 */
public class RecoverBinarySearchTree99 {
    //99. 恢复二叉搜索树
    //二叉搜索树中的两个节点被错误地交换。
    //
    //请在不改变其结构的情况下，恢复这棵树。
    //
    //示例 1:
    //
    //输入: [1,3,null,null,2]
    //
    //        1
    //        /
    //        3
    //        \
    //        2
    //
    //输出: [3,1,null,null,2]
    //
    //        3
    //        /
    //        1
    //        \
    //        2
    //示例 2:
    //
    //输入: [3,1,4,null,null,2]
    //
    //        3
    //        / \
    //        1   4
    //        /
    //        2
    //
    //输出: [2,1,4,null,null,3]
    //
    //        2
    //        / \
    //        1   4
    //        /
    //        3
    //进阶:
    //
    //使用 O(n) 空间复杂度的解法很容易实现。
    //你能想出一个只使用常数空间的解决方案吗？
    //https://leetcode-cn.com/problems/recover-binary-search-tree/
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        List<Integer> inOrder = new ArrayList<>();
        //中序遍历
        helper(inOrder,root);
        //找出不符合升序的两个数字
        int[] swapNums = findSwapNums(inOrder);
        //根据顺序恢复
        recover(root,2,swapNums[0],swapNums[1]);
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if(root==null || count==0){
            return;
        }
        if(root.val==x){
            root.val = y;
            count--;
        }else if(root.val==y){
            root.val = x;
            count--;
        }
        recover(root.left,count,x,y);
        recover(root.right,count,x,y);
    }

    private int[] findSwapNums(List<Integer> inOrder) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < inOrder.size()-1; i++) {
            if(inOrder.get(i)>inOrder.get(i+1)){
                //先找大的那个数字
                y = inOrder.get(i+1);
                if(x==-1){
                    x = inOrder.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    private void helper(List<Integer> inOrder, TreeNode root) {
        if(root==null){
            return;
        }
        helper(inOrder,root.left);
        inOrder.add(root.val);
        helper(inOrder,root.right);
    }
}
