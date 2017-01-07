/*
 According to the Wikipedia's article : "The Game of Life , also known simply as
Life , is a cellular automaton devised by the British mathematician John Horton
Conway in 1970."  Given a board with m by n cells, each cell has an initial
state live (1) or dead (0). Each cell interacts with its eight neighbors
(horizontal, vertical, diagonal) using the following four rules (taken from the
above Wikipedia article):    Any live cell with fewer than two live neighbors
dies, as if caused by under-population.  Any live cell with two or three live
neighbors lives on to the next generation.  Any live cell with more than three
live neighbors dies, as if by over-population..  Any dead cell with exactly
three live neighbors becomes a live cell, as if by reproduction.    Write a
function to compute the next state (after one update) of the board given its
current state.   Follow up :   Could you solve it in-place? Remember that the
board needs to be updated at the same time: You cannot update some cells first
and then use their updated values to update other cells.  In this question, we
represent the board using a 2D array. In principle, the board is infinite, which
would cause problems when the active area encroaches the border of the array.
How would you address these problems?    Credits: Special thanks to
@jianchao.li.fighter for adding this problem and creating all test cases.
Subscribe to see which companies asked this question    Show Tags   Array
Show Similar Problems   (M) Set Matrix Zeroes
*/


public class Solution {    public void gameOfLife(int[][] board) {        if (board == null || board.length == 0) return;        int m = board.length, n = board[0].length;        for (int i = 0; i < m; i++) {            for (int j = 0; j < n; j++) {                //count lives of each cell                int[] xs = {i-1, i, i+1};                int[] ys = {j-1, j, j+1};                int lives = 0;                for (int ii : xs) {                    if (ii >= 0 && ii < m) {                        for (int jj : ys) {                            if (jj >= 0 && jj < n && !(ii == i && jj == j)) {                                lives += board[ii][jj] & 1;                            }                        }                    }                }                // lives -= board[i][j] & 1;                // System.out.print(i+","+j+":"+lives+'\n');                // count next state                if (board[i][j] == 1 && lives >= 2 && lives <= 3)                    board[i][j] = 3;                if (board[i][j] == 0 && lives == 3)                    board[i][j] = 2;            }        }        //move next state to current        for (int i = 0; i < m; i++) {            for (int j = 0; j < n; j++) {                board[i][j] >>= 1;  // Get the 2nd state.            }        }    }}