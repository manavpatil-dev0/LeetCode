// //Method 1 :- Simulation/Traversal method
// class Solution {

//     public boolean checkValidGrid(int[][] grid) {

//         int n = grid.length;

        
//         if (grid[0][0] != 0) {
//             return false;
//         }

//         int row = 0;
//         int col = 0;
//         int current = 0;

//         int[][] moves = { // all 8 move of Knight
//             {2, 1},
//             {2, -1},
//             {-2, 1},
//             {-2, -1},
//             {1, 2},
//             {1, -2},
//             {-1, 2},
//             {-1, -2}
//         };

//         while (current < n * n - 1) {

//             boolean found = false;

//             for (int[] move : moves) {

//                 int newRow = row + move[0];
//                 int newCol = col + move[1];

//                 if (newRow >= 0 && newRow < n &&
//                     newCol >= 0 && newCol < n) {

//                     if (grid[newRow][newCol] == current + 1) {

//                         row = newRow;
//                         col = newCol;
//                         current++;

//                         found = true;
//                         break;
//                     }
//                 }
//             }

//             if (!found) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }



//Metho:- backtraking
class Solution {
    public static boolean isValid(int grid[][], int r, int c, int n, int expVal){
        if(r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != expVal){
            return false;
        }

        if(expVal == n*n-1){
            return true;
        }

        //8 Possible moves of knight
        boolean ans1 = isValid(grid, r-2, c+1, n,expVal + 1);
        boolean ans2 = isValid(grid, r-1, c+2, n,expVal + 1);
        boolean ans3 = isValid(grid, r+1, c+2, n, expVal + 1);
        boolean ans4 = isValid(grid, r+2, c+1, n, expVal + 1);
        boolean ans5 = isValid(grid, r+2, c-1, n, expVal + 1);
        boolean ans6 = isValid(grid, r+1, c-2, n, expVal + 1);
        boolean ans7 = isValid(grid, r-1, c-2, n, expVal + 1);
        boolean ans8 = isValid(grid, r-2, c-1, n, expVal + 1);
        

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;

        
    }

    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, grid.length, 0);

    }
}