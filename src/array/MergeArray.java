package array;

/**
 * @author think
 * @version v 1.0 2019/11/9 14:51
 */
public class MergeArray {
    public static void main(String[] args) {
        final MergeArray mergeArray = new MergeArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {5,6};
        mergeArray.merge(nums1,3,nums2,2);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m-1;
        int len2 = n-1;
        int len = m+n-1;
        while(len1>=0 && len2>=0){
            if(nums1[len1]>nums2[len2]){
                nums1[len--] = nums1[len1--];
            }else{
                nums1[len--] = nums2[len2--];
            }
        }
        if(len2>=0){
            for(int i=0; i!=len+1; i++){
                nums1[i] = nums2[i];
            }
        }
    }
}
