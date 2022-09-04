import java.util.Arrays;

class Solution {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = capacity.length;
        int[] diffs = new int[len];
        for (int i = 0; i < len; i++) {
            diffs[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diffs);
        int count = 0, ptr = 0;
        while (ptr < len) {
            int diff = diffs[ptr++];
            if (diff == 0) {
                ++count;
                continue;
            }
            if (additionalRocks < diff || additionalRocks == 0) {
                break;
            }
            ++count;
            additionalRocks -= diff;
        }
        return count;
    }


}