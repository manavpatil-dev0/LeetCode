class Solution {

    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        // Store existing digits
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] != '.') {
                    int num = board[r][c] - '0';
                    int box = (r / 3) * 3 + (c / 3);

                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[box][num] = true;
                }
            }
        }

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] != '.') {
                    continue;
                }

                int box = (r / 3) * 3 + (c / 3);

                for (int num = 1; num <= 9; num++) {

                    if (rows[r][num] ||
                        cols[c][num] ||
                        boxes[box][num]) {
                        continue;
                    }

                    // Place digit
                    board[r][c] = (char) ('0' + num);

                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[box][num] = true;

                    if (solve(board)) {
                        return true;
                    }

                    // Backtrack
                    board[r][c] = '.';

                    rows[r][num] = false;
                    cols[c][num] = false;
                    boxes[box][num] = false;
                }

                // No number works here
                return false;
            }
        }

        return true;
    }
}