package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/11/27 0:04
 */
public class FindLargestValueInEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i=0; i!=size; i++){
                TreeNode poll = queue.poll();
                if(poll.val>maxValue){
                    maxValue = poll.val;
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }
}
