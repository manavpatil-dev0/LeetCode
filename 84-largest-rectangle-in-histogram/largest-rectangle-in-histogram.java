import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {

                int height = heights[stack.pop()];

                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                int width = i - leftBoundary - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}