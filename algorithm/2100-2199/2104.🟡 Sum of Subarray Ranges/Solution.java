import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

class Solution {

    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < len - 1; i++) {
            max = nums[i];
            min = max;
            for (int j = i + 1; j < len; j++) {
                int cur = nums[j];
                if (cur > max) {
                    max = cur;
                } else if (cur < min) {
                    min = cur;
                }
                sum = sum + (max - min);
            }
            max = Long.MAX_VALUE;
            min = Long.MIN_VALUE;
        }
        return sum;
    }

}