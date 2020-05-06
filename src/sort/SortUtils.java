package sort;

import java.util.PriorityQueue;

/**
 * @author think
 * @version v 1.0 2019/12/14 12:26
 */
@SuppressWarnings("all")
public class SortUtils {
    public static void main(String[] args) {
        int[] arr = {1,2,6,4,3,8,7,5};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }

    public static void quickSort(int[] array){
        helperMergeSort(array,0,array.length-1);
    }


    public static void helperQuickSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid = partition(array,start,end);
        helperMergeSort(array,start,mid-1);
        helperMergeSort(array,mid+1,end);
    }

    private static int partition(int[] array,  int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;
        while(i<j){
            while(i<end && array[i]<pivot){
                i++;
            }
            while(j>start && array[j]>pivot){
                j--;
            }
            int temp  = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return j;
    }


    //堆排序
    public static void heapSort(int[] array){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = queue.poll();
        }
    }


    //冒泡排序
    public static void bubbleSort(int[] array){
        for (int i = array.length-1; i >=1 ; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }



    //选择排序
    public static void chooseSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[minIndex]>array[j]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }


    //插入排序
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int j  = i;
            int temp = array[j];
            while(j>=1 && temp<array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }



    //归并排序
    public static void mergeSort(int[] array){
        helperMergeSort(array,0,array.length-1);
    }

    public static void helperMergeSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid = (end-start)/2+start;
        helperMergeSort(array,start,mid);
        helperMergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(array[i]<array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        while(i<=mid){
            temp[k++] = array[i++];
        }
        while(j<=end){
            temp[k++] = array[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            array[l+start] = temp[l];
        }
    }
}
