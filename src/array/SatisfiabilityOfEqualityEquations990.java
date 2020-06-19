package array;

/**
 * @author think
 * @version v 1.0 2020/6/9 0:05
 */
public class SatisfiabilityOfEqualityEquations990 {
    //990. 等式方程的可满足性
    //给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
    //
    //只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
    //
    //
    //
    //示例 1：
    //
    //输入：["a==b","b!=a"]
    //输出：false
    //解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
    //示例 2：
    //
    //输出：["b==a","a==b"]
    //输入：true
    //解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
    //示例 3：
    //
    //输入：["a==b","b==c","a==c"]
    //输出：true
    //示例 4：
    //
    //输入：["a==b","b!=c","c==a"]
    //输出：false
    //示例 5：
    //
    //输入：["c==c","b==d","x!=z"]
    //输出：true
    //
    //
    //提示：
    //
    //        1 <= equations.length <= 500
    //equations[i].length == 4
    //equations[i][0] 和 equations[i][3] 是小写字母
    //equations[i][1] 要么是 '='，要么是 '!'
    //equations[i][2] 是 '='
    //https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
    public boolean equationsPossible(String[] equations) {
        if(equations.length==0){
            return true;
        }
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            int index1 = chars[0] - 'a';
            int index2 = chars[3] - 'a';
            if(chars[1]=='='){
                unionFind.union(index1,index2);
            }
        }

        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            int index1 = chars[0] - 'a';
            int index2 = chars[3] - 'a';
            if(chars[1]=='!'){
                if(unionFind.isConnect(index1,index2)){
                    return false;
                }
            }
        }
        return true;
    }
    class UnionFind{
        int[] parent;
        int count;
        UnionFind(int i){
            count = i;
            parent = new int[i];
            for (int j = 0; j <i; j++) {
                parent[j] = j;
            }
        }

        public int find(int x){
            while(x!=parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int i, int j){
            int i1 = find(i);
            int i2 = find(j);
            if(i1!=i2){
                count--;
                parent[i1] = i2;
            }
        }

        public boolean isConnect(int i, int j){
            int i1 = find(i);
            int i2 = find(j);
            return i1==i2;
        }
    }
}
