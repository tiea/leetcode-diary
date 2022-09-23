import java.util.Arrays;

class Solution {

    public int[] frequencySort(int[] nums) {
        int len = nums.length;
        int cur = 0;
        int max = -101;
        int min = 101;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            max = Math.max(cur, max);
            min = Math.min(cur, min);
        }
        int maxLen = max - min + 1;
        
        int[] idx = new int[maxLen];
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            idx[cur - min]++;
        }
        Integer[] idxSort = new Integer[maxLen];
        for (int i = 0; i < maxLen; i++) {
            idxSort[i] = i;
        }
        Arrays.sort(idxSort, (l, r) -> {
            if (idx[l] == idx[r]) {
                return r - l; 
            }
            return idx[l] - idx[r];
        });
        int[] ans = new int[len];
        int pos = 0;
        for (int i = 0; i < maxLen; i++) {
            int count = idx[idxSort[i]];
            if (count == 0) {
                continue;
            }
            for (int j = 0; j < count; j++) {
                ans[pos++] = idxSort[i] + min;
            }
        }
        return ans;
    }

}