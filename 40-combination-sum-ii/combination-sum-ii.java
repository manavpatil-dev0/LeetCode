import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate choices at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted, no later element can work
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            // i + 1 because each element can be used only once
            backtrack(
                candidates,
                target - candidates[i],
                i + 1,
                current,
                result
            );

            current.remove(current.size() - 1);
        }
    }
}