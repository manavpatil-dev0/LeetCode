import java.util.AbstractList;

class Solution {
    private List<List<Integer>> mList;
    private HashSet<List<Integer>> set;

    public List<List<Integer>> combinationSum2(int[] arr, int k) {
        return new AbstractList<List<Integer>>() {
            @Override
            public int size() {
                init();
                return mList.size();
            }

            @Override
            public List<Integer> get(int i) {
                init();
                return mList.get(i);
            }

            private void init() {
                if (mList != null)
                    return;
                set = new HashSet<>();
                Arrays.sort(arr);
                counter(arr, 0, 0, k, new ArrayList<Integer>());
                mList = new ArrayList<>(set);

            }
        };
    }

    private void counter(int[] arr, int i, int sum, int k, List<Integer> list) {
        if (sum == k) {
            set.add(new ArrayList<>(list));
            return;
        }
        if (i == arr.length || sum > k)
            return;
        list.add(arr[i]);
        counter(arr, i + 1, sum + arr[i], k, list);
        list.remove(list.size() - 1);
        int next = i + 1;
        while (next < arr.length && arr[next] == arr[i]) {
            next++;
        }
        counter(arr, next, sum, k, list);
    }
}