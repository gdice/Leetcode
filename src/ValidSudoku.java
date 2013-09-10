/**
 * Created with IntelliJ IDEA.
 * User: Tyler Sun
 * Date: 9/9/13
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
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
                    return false;
                rows[i] += (1 << k);
                cols[j] += (1 << k);
                blocks[b] += (1 << k);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        String[] str = new String[] {".........",".........",".........",".........",".........",".........",".........",".........","........."};
        char[][] board = new char[9][9];

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                board[i][j] = str[i].charAt(j);
        System.out.println(v.isValidSudoku(board));
    }
}
