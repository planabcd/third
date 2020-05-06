package trie;

/**
 * @author think
 * @version v 1.0 2019/12/11 0:23
 */
public class SurroudedRegions130 {
    //给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
    //
    //找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
    //
    //示例:
    //
    //X X X X
    //X O O X
    //X X O X
    //X O X X
    //运行你的函数后，矩阵变为：
    //
    //X X X X
    //X X X X
    //X X X X
    //X O X X
    //解释:
    //
    //被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
    //
    //在真实的面试中遇到过这道题？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/surrounded-regions

    //dfs
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(i==0 || i==rows-1 || j==0 || j==cols-1){
                    dfs(i,j,board);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(int row, int col, char[][] board) {
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return;
        }
        if(board[row][col]=='#' || board[row][col]=='X'){
            return;
        }
        if(board[row][col]=='O'){
            board[row][col] = '#';
        }
        dfs(row+1,col,board);
        dfs(row-1,col,board);
        dfs(row,col+1,board);
        dfs(row,col-1,board);
    }

}
