class Solution {
    public int[] sortArray(int[] nums) {

        int n = nums.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Extract maximum element
        for (int end = n - 1; end > 0; end--) {

            swap(nums, 0, end);

            heapify(nums, end, 0);
        }

        return nums;
    }

    private void heapify(int[] nums, int size, int root) {

        while (true) {

            int largest = root;
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            if (left < size && nums[left] > nums[largest]) {
                largest = left;
            }

            if (right < size && nums[right] > nums[largest]) {
                largest = right;
            }

            if (largest == root) {
                break;
            }

            swap(nums, root, largest);
            root = largest;
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}