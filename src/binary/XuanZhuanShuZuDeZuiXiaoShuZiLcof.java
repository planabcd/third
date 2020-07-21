package binary;

/**
 * @author think
 * @version v 1.0 2020/7/22 1:24
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    //剑指 Offer 11. 旋转数组的最小数字
    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
    //
    //示例 1：
    //
    //输入：[3,4,5,1,2]
    //输出：1
    //示例 2：
    //
    //输入：[2,2,2,0,1]
    //输出：0
    //https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
    public int minArray(int[] numbers) {
        //3,4,5,1,2
        if(numbers.length==0){
            return 0;
        }
        if(numbers.length==1){
            return numbers[0];
        }
        if(numbers[numbers.length-1]>numbers[0]){
            return numbers[0];
        }
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(numbers[mid]<numbers[right]){
                right = mid;
            }else if(numbers[mid]>numbers[right]){
                left = mid+1;
            }else{
                right = right-1;
            }
        }
        return numbers[left];
    }
}
