package stack;

import java.util.Stack;

/**
 * @author think
 * @version v 1.0 2020/5/30 18:03
 */
public class LargestRectangleInHistogram84 {
    //84. 柱状图中最大的矩形
    //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    //
    //求在该柱状图中，能够勾勒出来的矩形的最大面积。
    //https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

    //举个例子，配合下图，现在索引在 6 ，栈里是 1 5 6 。
    //接下来新元素是 2 ，那么 6 需要出栈。
    //当 6 出栈时，右边 2 代表是 6 右边第一个比 6 小的元素。
    //
    //当元素出栈后，说明新栈顶元素是出栈元素向前找第一个比其小的元素
    //当 6 出栈时，5 成为新的栈顶，那么 5 就是 6 左边第一个比 6 小的元素
    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram84().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }


    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int res = Integer.MIN_VALUE;
        //heights[index]<indexStack.peek() 要满足条件栈顶peek的下一个元素是左边第一个比peek小的,当前元素是右边第一个比peek小的
        for (int i = 0; i < heights.length; i++) {
            while(indexStack.peek()!=-1 && heights[i]<heights[indexStack.peek()]){
                int cur = indexStack.peek();
                indexStack.pop();
                int left = indexStack.peek()+1;
                int right = i-1;
                res = Math.max(res,heights[cur]*(right-left+1));
            }
            indexStack.push(i);
        }
        while(indexStack.peek()!=-1){
            int cur = indexStack.peek();
            indexStack.pop();
            int left = indexStack.peek()+1;
            int right = heights.length-1;
            res = Math.max(res,heights[cur]*(right-left+1));
        }
        return res;
    }

}
