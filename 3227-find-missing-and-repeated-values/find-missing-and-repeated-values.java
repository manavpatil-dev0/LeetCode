class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        long N = 1L * n * n;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                actualSquareSum += 1L * num * num;
            }
        }

        long expectedSum = N * (N + 1) / 2;
        long expectedSquareSum = N * (N + 1) * (2 * N + 1) / 6;

        long diff = actualSum - expectedSum;                 // repeated - missing
        long squareDiff = actualSquareSum - expectedSquareSum;

        long sum = squareDiff / diff;                        // repeated + missing

        int repeated = (int) ((diff + sum) / 2);
        int missing = (int) (sum - repeated);

        return new int[]{repeated, missing};
    }
}