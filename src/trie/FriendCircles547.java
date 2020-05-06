package trie;

/**
 * @author think
 * @version v 1.0 2019/12/10 23:07
 */
public class FriendCircles547 {
    public static void main(String[] args) {
        int[][] m = {{1,1,0},
                    {1,1,0},
                    {0,0,1}};
        int circleNum = new FriendCircles547().findCircleNum(m);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] M) {
        if(M.length==0){
            return 0;
        }
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 1; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if(M[i][j]==1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.count;
    }
}

class UnionFind{
    int[] parent;
    int count;

    public UnionFind(int i){
        parent = new int[i];
        count = i;
        for (int j = 0; j < i; j++) {
            parent[j] = j;
        }
    }

    public int find(int p){
        while(p!=parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ){
            return;
        }else{
            parent[rootP] = rootQ;
            count--;
        }
    }


}
