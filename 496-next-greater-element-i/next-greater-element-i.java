import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // Find next greater element for every value in nums2
        for (int num : nums2) {

            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Elements remaining in stack have no greater element
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            answer[i] = nextGreater.get(nums1[i]);
        }

        return answer;
    }
}