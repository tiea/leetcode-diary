import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

class Solution {
    
    public int longestConsecutive(int[] nums) {
    }

    public int longestConsecutiveByHash(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        SortedSet<Integer> numSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            numSet.add(nums[i]);
        }
        Iterator<Integer> iterator = numSet.iterator();
        int pre = iterator.next();
        int max = 1;
        int ans = 1;
        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (cur == pre + 1) {
                ans++;
            } else {
                max = Math.max(max, ans);
                ans = 1;
            }
            pre = cur;
        }
        max = Math.max(max, ans);
        return max;
    }

}