package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/9/16 23:51
 */
public class SudokuSolver37 {
    //37. 解数独
    //编写一个程序，通过已填充的空格来解决数独问题。
    //
    //一个数独的解法需遵循如下规则：
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    //空白格用 '.' 表示。
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] blocks = new boolean[3][3][9];
    boolean valid = false;
    List<int[]> lines = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(board[row][col]=='.'){
                    //把待填空的坐标放到一个list里做递归处理
                    lines.add(new int[]{row, col});
                }else{
                    int number = board[row][col] - '0' - 1;
                    //标记当前数字已经被使用
                    rows[row][number] = cols[col][number] = blocks[row/3][col/3][number] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int start) {
        if(start==lines.size()){
            valid = true;
            return;
        }
        for (int number = 0; number < 9 && !valid; number++) {
            int[] ints = lines.get(start);
            int row = ints[0];
            int col = ints[1];
            if(!rows[row][number] && !cols[col][number] && !blocks[row/3][col/3][number]){
                rows[row][number] = cols[col][number] = blocks[row/3][col/3][number] = true;
                board[row][col] = (char) (number+1+'0');
                dfs(board, start+1);
                rows[row][number] = cols[col][number] = blocks[row/3][col/3][number] = false;
            }
        }
    }
}
