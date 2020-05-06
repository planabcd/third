package dfs;

/**
 * @author think
 * @version v 1.0 2019/11/29 0:15
 */
public class NumberOfIslands200 {
    public static void main(String[] args) {
        //char[][] grid = {
        //        {'1','1','1','1','0'},
        //        {'1','1','0','1','0'},
        //        {'1','1','0','0','0'},
        //        {'0','0','1','0','1'}
        //};
        char[][] grid ={{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        int result = new NumberOfIslands200().numIslands(grid);
        System.out.println(result);
    }

    //并查集
    public int numIslands(char[][] grid) {
        if(grid.length ==0 || grid[0].length ==0){
            return 0;
        }
        int cols = grid[0].length;
        int rows = grid.length;
        int count = rows * cols;
        UnionFind unionFind = new UnionFind(count+1);
        int[] x = {1,0};
        int[] y = {0,1};
        for(int i = 0; i!= rows; i++) {
            for (int j = 0; j != grid[i].length; j++) {
                if(grid[i][j]=='0'){
                    unionFind.union(i*cols+j,count);
                }else{
                    for (int k = 0; k < 2; k++) {
                        int newX = i + x[k];
                        int newY = j + y[k];
                        if(newX>=0 && newX< rows && newY>=0 && newY< cols){
                            if(grid[newX][newY]=='1'){
                                unionFind.union(i*cols+j,newX*cols+newY);
                            }/*else{
                                unionFind.union(count,newX*cols+newY);
                            }*/
                        }
                    }
                }
            }
        }
        return unionFind.count-1;
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
            if(rootP!=rootQ){
                parent[rootP] = rootQ;
                count--;
            }
        }


    }


    //dfs
    public int numIslands1(char[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int result = 0;
        int[] x = {0,0,-1,1};
        int[] y = {-1,1,0,0};
        for(int i=0; i!=grid.length; i++){
            for(int j=0; j!=grid[i].length; j++){
                if(grid[i][j]=='0'){
                    continue;
                }
                result++;
                dfs(grid,i,j,x,y);
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j, int[] x, int[] y) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k !=x.length; k++) {
            int xi = x[k];
            int yi = y[k];
            dfs(grid,i+xi,j+yi,x,y);
        }
    }


}
