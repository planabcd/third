package tree;

/**
 * @author think
 * @version v 1.0 2019/12/22 17:25
 */
public class VerifyPreorderSequenceInBinarySearchTree255 {

    public static void main(String[] args) {
        final boolean b = new VerifyPreorderSequenceInBinarySearchTree255().verifyPreorder(new int[]{1,2});
        System.out.println(b);
    }

    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length==0){
            return true;
        }
        return helper(preorder,0,preorder.length-1);
    }
    public boolean helper(int[] preorder,int start,int end) {
        if(start==end){
            return true;
        }
        //最后一个小于root的 i
        //第一个大于root的 j
        int i = -1;
        int j = -1;
        int root = preorder[start];
        for (int k = start+1; k <= end; k++) {
            if(preorder[k]<root){
                i = k;
            }else{
                if(j==-1){
                    j = k;
                }
            }
        }
        if(i==-1 || j==-1){
            return helper(preorder,start+1,end);
        }
        if(i+1!=j){
            return false;
        }
        return helper(preorder,start+1,i) && helper(preorder,j,end);
    }
}
