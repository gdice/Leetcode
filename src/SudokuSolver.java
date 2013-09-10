/**
 * Created with IntelliJ IDEA.
 * User: Tyler Sun
 * Date: 9/9/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuSolver {
    public boolean solve(char[][] board, int[] rows, int[] cols, int[] blocks) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.')
                    continue;
                int b = (i / 3) * 3 + (j / 3);
                for (int k = 1; k <= 9; ++k) {
                    if ((rows[i] & (1 << k)) > 0 || (cols[j] & (1 << k)) > 0 || (blocks[b] & (1 << k)) > 0)
                        continue;
                    board[i][j] = (char)('0' + k);
                    rows[i] += (1 << k);
                    cols[j] += (1 << k);
                    blocks[b] += (1 << k);
                    if (solve(board, rows, cols, blocks))
                        return true;
                    board[i][j] = '.';
                    rows[i] -= (1 << k);
                    cols[j] -= (1 << k);
                    blocks[b] -= (1 << k);
                }
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blocks = new int[9];



        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.')
                    continue;
                int b = (i / 3) * 3 + (j / 3);
                int k = board[i][j] - '0';
                if ((rows[i] & (1 << k)) > 0 || (cols[j] & (1 << k)) > 0 || (blocks[b] & (1 << k)) > 0)
                    return;
                rows[i] += (1 << k);
                cols[j] += (1 << k);
                blocks[b] += (1 << k);
            }
        }
        solve(board, rows, cols, blocks);
    }

    public static void main(String[] args) {
        SudokuSolver v = new SudokuSolver();
        String[] str = new String[] {".........",".........",".........",".........",".........",".........",".........",".........","........."};
        char[][] board = new char[9][9];

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                board[i][j] = str[i].charAt(j);
        v.solveSudoku(board);
        System.out.println();
    }
}
