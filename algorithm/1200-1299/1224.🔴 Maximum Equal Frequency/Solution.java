import java.util.Map;
import java.util.Set;
import java.util.HashMap;

class Solution {

    public int maxEqualFreq(int[] nums) {
        int length = nums.length;
        int prt = 1, max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        map.put(nums[0], 1);
        countMap.put(1, 1);
        while(prt < length) {
            int num = nums[prt];
            Integer count = map.get(num);
            if (count == null) {
                count = 0;
            }
            if (count != 0) {
                Integer countCount = countMap.get(count);
                countCount--;
                if (countCount == 0) {
                    countMap.remove(count);
                } else {
                    countMap.put(count, countCount);
                }
            }
            count++;
            map.put(num, count);
            Integer countCount = countMap.get(count);
            if (countCount == null) {
                countCount = 0;
            }
            countCount++;
            countMap.put(count, countCount);

            boolean flag = check(countMap);
            if (flag) {
                max = prt + 1;
            }
            prt++;
        }
        return max;
    }

    private boolean check(Map<Integer, Integer> map) {
        if (map.size() > 2) {
            return false;
        }
        int f = 0, s = 0;
        int fCount = 0, sCount = 0;
        int cur = 0;
        Set<Integer> keys = map.keySet();
        for(Integer key : keys) {
            Integer count = map.get(key);
            if (cur == 0) {
                f = key;
                fCount = count;
                cur++;
                continue;
            }
            if (cur == 1) {
                s = key;
                sCount = count;
            }
        }
        if ((f == 1 || fCount == 1) && s == 0) {
            return true;
        }
        if (fCount == 1 && (f - s == 1 || f == 1)) {
            return true;
        }
        if (sCount == 1 && (s - f == 1 || s == 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().maxEqualFreq(new int[]{1,1});
    }

}