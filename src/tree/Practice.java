package tree;

import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/12/27 22:36
 */
public class Practice {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int maxDepth = 0;
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth,maxDepth(child));
        }
        return maxDepth+1;
    }
}
