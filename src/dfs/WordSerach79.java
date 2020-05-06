package dfs;

/**
 * @author think
 * @version v 1.0 2019/12/20 1:29
 */
public class WordSerach79 {

    public boolean exist(char[][] board, String word) {
        if(board.length==0 || board[0].length==0 || word.length()==0){
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int index, String word) {
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return false;
        }
        if(board[row][col]=='#'){
            return false;
        }
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean dfs1 = dfs(board, row + 1, col, index + 1, word);
        boolean dfs2 = dfs(board, row - 1, col, index + 1, word);
        boolean dfs3 = dfs(board, row, col+1, index + 1, word);
        boolean dfs4 = dfs(board, row, col-1, index + 1, word);
        if(dfs1 || dfs2 || dfs3 || dfs4){
            return true;
        }
        board[row][col] = temp;
        return false;
    }
}
