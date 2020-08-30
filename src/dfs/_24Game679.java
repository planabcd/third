package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/8/23 21:11
 */
public class _24Game679 {
    //679. 24 点游戏
    //你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
    //
    //示例 1:
    //
    //输入: [4, 1, 8, 7]
    //输出: True
    //解释: (8-4) * (7-1) = 24
    //示例 2:
    //
    //输入: [1, 2, 1, 2]
    //输出: False
    //注意:
    //
    //除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
    //每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
    //你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
    public static void main(String[] args) {
        System.out.println(new _24Game679().judgePoint24(new int[]{4,1,8,7}));
        System.out.println(new _24Game679().judgePoint24(new int[]{1,2,1,2}));
    }
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add((double)nums[i]);
        }
        return helper(list);
    }

    private boolean helper(List<Double> list) {
        if(list.size()==1){
            return Math.abs(list.get(0)-24)<0.0001;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                //先移除后面的元素
                boolean valid = false;
                List<Double> copy = new ArrayList<>(list);
                double a = copy.remove(j);
                double b = copy.remove(i);
                copy.add(a+b);
                valid = valid || helper(copy);

                copy.set(copy.size()-1, a-b);
                valid = valid || helper(copy);

                copy.set(copy.size()-1, b-a);
                valid = valid || helper(copy);

                copy.set(copy.size()-1, a*b);
                valid = valid || helper(copy);

                if(b!=0){
                    copy.set(copy.size()-1, a/b);
                    valid = valid || helper(copy);
                }
                if(a!=0){
                    copy.set(copy.size()-1, b/a);
                    valid = valid || helper(copy);
                }
                if(valid){
                    return true;
                }
            }
        }
        return false;
    }
}
