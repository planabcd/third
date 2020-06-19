package stack;

import java.util.Stack;

/**
 * @author think
 * @version v 1.0 2020/6/11 22:40
 */
public class DailyTemperatures739 {
    //739. 每日温度
    //请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    //
    //例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
    //
    //提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
    //https://leetcode-cn.com/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if(T.length==0){
            return res;
        }
        //stack从栈底到栈顶是单调递减,存的是T数组的索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            //80-70-60   75
            while(!stack.isEmpty() && T[stack.peek()]<T[i]){
                //如果栈顶元素小于当前元素,说明不符合单调栈性质,需要把栈顶元素移除直到栈顶元素小于等于当前元素
                Integer pop = stack.pop();
                //当前元素是第一个比栈顶元素大的元素
                res[pop]  = i-pop;
            }
            stack.push(i);
        }
        return res;
    }

    //def get_week_schedule(ad):
    //        if ad.data_dict.get('week_schedule'):
    //ret = ''
    //        for item in ad.data_dict['week_schedule']:
    //        if item:
    //ret = ''.join([str(item[0] / 2), ':'])
    //        if item[0] % 2:
    //ret = ''.join([ret, '30-'])
    //            else:
    //ret = ''.join([ret, '00-'])
    //ret = ''.join([ret, str((item[-1] + 1) / 2), ':'])
    //        if (item[-1] + 1) % 2:
    //ret = ''.join([ret, '30'])
    //            else:
    //ret = ''.join([ret, '00'])
    //    return ret
    //else:
    //        return ''
}
