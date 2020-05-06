package array;

/**
 * @author liaoxin
 * @version v 1.0 2020/2/2 22:58
 */
public class SortColors75 {

    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

    //此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    //
    //注意:
    //不能使用代码库中的排序函数来解决这道题。
    //
    //示例:
    //
    //输入: [2,0,2,1,1,0]
    //输出: [0,0,1,1,2,2]
    //进阶：
    //
    //一个直观的解决方案是使用计数排序的两趟扫描算法。
    //首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
    //你能想出一个仅使用常数空间的一趟扫描算法吗？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/sort-colors

    public static void main(String[] args) {
        //int[] nums = {2,0,2,1,1,0};
        int[] nums = {1,2,0};
        new SortColors75().sortColors(nums);
        for (int num : nums) {
            System.out.print(num+"\t");
        }

    }

    public void sortColors(int[] nums) {
        if(nums.length<=1){
            return;
        }
        //p0左边的元素都是0
        int p0 = 0;
        //p2右边的元素都是2
        int p2 = nums.length-1;
        int cur = 0;
        while(cur<=p2){
            if(nums[cur]==0){
                swap(nums,cur++,p0++);
            }else if(nums[cur]==2){
                swap(nums,cur,p2--);
            }else{
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
