package sort;

/**
 * @author think
 * @version v 1.0 2019/9/7 21:37
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 5, 4};
        printArray(array);
        insertSort(array);
        printArray(array);
    }

    public static void printArray(int[] array){
        for (int num : array) {
            System.out.print(num+" ");
        }
    }

    public static void insertSort(int[] array){
        for (int i = 0; i !=array.length-1; i++) {
            int j = i+1;
            int temp = array[j];
            for(; j>0 ; j--){
                if(temp<array[j-1]){
                    array[j] = array[j-1];
                }else{
                    break;
                }
            }
            array[j] = temp;
        }
    }

}
