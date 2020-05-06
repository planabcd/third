package dfs;

/**
 * @author think
 * @version v 1.0 2019/12/1 14:28
 */
public class Minesweeper529 {
    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] chars = new Minesweeper529().updateBoard(board, click);
        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }


    public char[][] updateBoard(char[][] board, int[] click) {
        if (click.length != 2) {
            return board;
        }
        if (board.length == 0 || board[0].length == 0) {
            return new char[0][0];
        }
        //dest[0] x轴,dest[0][0] y轴
        int[][] dest = {
                {-1, 0, 1, -1, 1, -1, 0, 1},
                {-1, -1, -1, 0, 0, 1, 1, 1}
        };
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(click[0], click[1], board, dest);
        return board;

    }

    private void dfs(int row, int col, char[][] board, int[][] dest) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }
        if (board[row][col] == 'E') {
            int count = count(row, col, board, dest);
            if(count==0){
                board[row][col] = 'B';
                for (int i = 0; i != dest[0].length; i++) {
                    int newRow = row + dest[1][i];
                    int newCol = col + dest[0][i];
                    dfs(newRow,newCol , board, dest);
                }
            }else{
                board[row][col] = (char) (count + '0');
            }
        }
    }

    private int count(int row, int col, char[][] board, int[][] dest) {
        int count = 0;
        for (int i = 0; i != dest[0].length; i++) {
            int newRow = row + dest[1][i];
            int newCol = col + dest[0][i];
            if (newRow < 0 || newRow > board.length - 1 || newCol < 0 || newCol > board[0].length - 1) {
                continue;
            }
            if (board[newRow][newCol] == 'M') {
                count++;
            }
        }
        return count;
    }
}
