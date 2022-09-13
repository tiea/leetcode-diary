import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;

class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Integer[] sortPos = new Integer[len];
        for (int i = 0; i < len; i++) {
            sortPos[i] = i;
        }
        Arrays.sort(sortPos, (l, r) -> {
            return quality[r] * wage[l] - quality[l] * wage[r];
        });
        double ans = Double.MAX_VALUE;
        double totalQ = 0.0;
        Queue<Integer> pq = new PriorityQueue<>((l, r) -> r - l);
        for (int i = 0; i < k - 1; i++) {
            int q = quality[sortPos[i]];
            totalQ += q;
            pq.offer(q);
        }
        for (int i = k - 1; i < len; i++) {
            int pos = sortPos[i];
            totalQ += quality[pos];
            pq.offer(quality[pos]);
            double totalc = ((double) wage[pos] / quality[pos]) * totalQ;

            ans = Math.min(ans, totalc);
            totalQ -= pq.poll();
        }
        return ans;
    }

}