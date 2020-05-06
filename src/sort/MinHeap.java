package sort;

/**
 * @author think
 * @version v 1.0 2019/12/14 13:23
 */
@SuppressWarnings("all")
public class MinHeap {
    public static void main(String[] args) {
        //}
        final MinHeap minHeap = new MinHeap(10);
        minHeap.offer(2);
        minHeap.offer(9);
        minHeap.offer(4);
        minHeap.offer(5);
        minHeap.offer(6);
        minHeap.offer(7);
        minHeap.offer(3);
    }

    public static void heapSort(int[] array){
        MinHeap minHeap = new MinHeap(array.length);
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = minHeap.poll();
        }
    }

    int[] array;
    int size = 0;
    MinHeap(int capacity){
        array = new int[capacity];
    }

    public void offer(int num){
        array[size++] = num;
        upJust();
    }

    public int poll(){
        int temp = array[0];
        array[0] = array[--size];
        downJust();
        return temp;
    }

    private void upJust() {
        int index = size-1;
        int temp = array[index];
        int parentIndex = (index-1)/2;
        while(parentIndex>=0 && temp<array[parentIndex]){
            array[index] = array[parentIndex];
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
        array[index] = temp;

    }

    private void downJust() {
        int index = 0;
        int temp = array[index];
        int childIndex = (index*2)+1;
        while(childIndex<size){
            if(childIndex+1<size){
                if(array[childIndex+1]<array[childIndex]){
                   childIndex = childIndex+1;
                }
            }
            if(array[childIndex]<temp){
                array[index] = array[childIndex];
                index = childIndex;
                childIndex = (index*2)+1;
            }else{
                break;
            }
        }
        array[index] = temp;
    }

}
