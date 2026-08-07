class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        
        // Optimization 1: frequency check - fail fast if board lacks enough chars
        int[] count = new int[128];
        for (char[] row : board)
            for (char ch : row) count[ch]++;
        
        for (char ch : word.toCharArray()) {
            count[ch]--;
            if (count[ch] < 0) return false; // board can't possibly form word
        }
        
        // Optimization 2: if last char is rarer on board than first char,
        // reverse the word so backtracking prunes dead ends faster
        char[] w = word.toCharArray();
        int[] freq = new int[128];
        for (char[] row : board)
            for (char ch : row) freq[ch]++;
        if (freq[w[0]] > freq[w[w.length - 1]]) {
            reverse(w);
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == w[0]) {
                    if (backtrack(board, w, r, c, 0)) return true;
                }
            }
        }
        return false;
    }
    
    private void reverse(char[] w) {
        int i = 0, j = w.length - 1;
        while (i < j) {
            char t = w[i]; w[i] = w[j]; w[j] = t;
            i++; j--;
        }
    }
    
    private boolean backtrack(char[][] board, char[] word, int r, int c, int idx) {
        if (idx == word.length) return true;
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length 
            || board[r][c] != word[idx]) {
            return false;
        }
        
        char temp = board[r][c];
        board[r][c] = '#';
        
        boolean found = backtrack(board, word, r+1, c, idx+1)
                      || backtrack(board, word, r-1, c, idx+1)
                      || backtrack(board, word, r, c+1, idx+1)
                      || backtrack(board, word, r, c-1, idx+1);
        
        board[r][c] = temp;
        return found;
    }
}