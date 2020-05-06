package sort;

/**
 * @author think
 * @version v 1.0 2019/12/14 15:13
 */
public class RelativeSortArray1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ints = new RelativeSortArray1122().relativeSortArray(arr1, arr2);
        for (int i : ints) {
            System.out.print(i+"\t");
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countArr = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            countArr[arr1[i]]+=1;
        }
        int[] res = new int[arr1.length];
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            while(countArr[arr2[i]]>0){
                res[k++] = arr2[i];
                countArr[arr2[i]]-=1;
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            while(countArr[i]>0){
                res[k++] = i;
                countArr[i]-=1;
            }
        }
        return res;
    }
}
