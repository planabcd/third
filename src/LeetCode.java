/**
 * @author think
 * @version v 1.0 2020/11/14 11:13
 */
public class LeetCode {
    public static void main(String[] args) {
        int[] ints = new LeetCode().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        for (int anInt : ints) {
            System.out.print(anInt+"\t");
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            counts[arr1[i]]++;
        }
        //counts = {3:2,5:3}
        //arr2 = [3,2]
        int[] results = new int[arr1.length];
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            int cur = arr2[i];
            while(counts[cur]!=0){
                results[j++] = cur;
                counts[cur]--;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            while(counts[i]!=0){
                results[j++] = i;
                counts[i]--;
            }
        }
        return results;
    }
}
