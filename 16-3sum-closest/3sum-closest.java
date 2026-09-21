import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Check if current sum is closer
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                // Exact match
                if (sum == target) {
                    return sum;
                }

                // Need larger sum
                if (sum < target) {
                    left++;
                }

                // Need smaller sum
                else {
                    right--;
                }
            }
        }

        return closest;
    }
}