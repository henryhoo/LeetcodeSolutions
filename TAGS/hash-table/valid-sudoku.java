/*
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules .  The
Sudoku board could be partially filled, where empty cells are filled with the
character '.' .    A partially filled sudoku which is valid.   Note: A valid
Sudoku board (partially filled) is not necessarily solvable. Only the filled
cells need to be validated.   Subscribe to see which companies asked this
question    Show Tags   Hash Table     Show Similar Problems   (H) Sudoku Solver
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                if (set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    else set.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !set.add(board[RowIndex + j/3][ColIndex + j%3]))    return false;
            }
        }
        return true;
    }
}
