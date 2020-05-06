package trie;

/**
 * @author think
 * @version v 1.0 2019/12/12 21:34
 */
public class ValidSuduko36 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean validSudoku = new ValidSuduko36().isValidSudoku(board);
        System.out.println(validSudoku);
    }

    //判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/valid-sudoku
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public boolean isValidSudoku(char[][] board) {
        int[][] block = new int[9][9];
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j]-'0';
                    int blockIndex = (i / 3) * 3 + j / 3;
                    if (block[blockIndex][num -1] >= 1 || row[i][num -1] >= 1 || col[num -1][j] >= 1) {
                        return false;
                    }
                    block[blockIndex][num -1] = 1;
                    row[i][num -1] = 1;
                    col[num -1][j] = 1;
                }
            }
        }
        return true;
    }
}
