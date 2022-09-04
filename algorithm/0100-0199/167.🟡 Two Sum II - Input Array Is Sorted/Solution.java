import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> posMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            posMap.put(numbers[i], i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < len; i++) {
            int f = numbers[i];
            if (posMap.containsKey(target - f)) {
                ans[0] = i + 1;
                ans[1] = posMap.get(target - f) + 1;
                break;
            }
        }
        return ans;
    }

}