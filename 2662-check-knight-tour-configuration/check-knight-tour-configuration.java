class Solution {
    public boolean checkValidGrid(int[][] grid) {

        int n = grid.length;

        // Must start at top-left
        if (grid[0][0] != 0) {
            return false;
        }

        int[][] pos = new int[n * n][2];

        // Store position of each move
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                int move = grid[r][c];

                pos[move][0] = r;
                pos[move][1] = c;
            }
        }

        // Check every consecutive move
        for (int move = 1; move < n * n; move++) {

            int r1 = pos[move - 1][0];
            int c1 = pos[move - 1][1];

            int r2 = pos[move][0];
            int c2 = pos[move][1];

            int rowDiff = Math.abs(r1 - r2);
            int colDiff = Math.abs(c1 - c2);

            // Knight move:
            // (2,1) or (1,2)
            if (!((rowDiff == 2 && colDiff == 1) ||
                  (rowDiff == 1 && colDiff == 2))) {
                return false;
            }
        }

        return true;
    }
}