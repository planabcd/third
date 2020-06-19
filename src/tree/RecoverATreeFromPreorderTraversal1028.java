package tree;

import java.util.Stack;

/**
 * @author think
 * @version v 1.0 2020/6/20 3:38
 */
public class RecoverATreeFromPreorderTraversal1028 {
    //1028. 从先序遍历还原二叉树
    //我们从二叉树的根节点 root 开始进行深度优先搜索。
    //
    //在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
    //
    //如果节点只有一个子节点，那么保证该子节点为左子节点。
    //
    //给出遍历输出 S，还原树并返回其根节点 root。
    //输入："1-2--3--4-5--6--7"
    //输出：[1,2,5,3,4,6,7]
    //https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while(index<S.length()){
            int level = 0;
            int num = 0;
            while(index<S.length() && S.charAt(index)=='-'){
                level++;
                index++;
            }
            while(index<S.length() && S.charAt(index)!='-'){
                num = num*10 + (S.charAt(index)-'0');
                index++;
            }
            TreeNode cur = new TreeNode(num);
            if(stack.size()==level){
                if(!stack.isEmpty()){
                    stack.peek().left = cur;
                }
            }else{
                while(stack.size()!=level){
                    stack.pop();
                }
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        while(stack.size()>1){
            stack.pop();
        }
        return stack.peek();
    }
}
