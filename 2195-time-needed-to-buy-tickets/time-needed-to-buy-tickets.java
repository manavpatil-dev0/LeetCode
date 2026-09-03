class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int target = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], target);
            } else {
                time += Math.min(tickets[i], target - 1);
            }
        }

        return time;
    }
}