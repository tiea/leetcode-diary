import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    // 排序
    public boolean canBeEqual(int[] target, int[] arr) {
        int length = target.length;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    // 哈希
    public boolean canBeEqualHash(int[] target, int[] arr) {
        int length = target.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < length; i++) {
            cur = target[i];
            Integer count = countMap.get(cur);
            if (count == null) {
                count = 0;
            }
            countMap.put(cur, ++count);
        }
        for (int i = 0; i < length; i++) {
            cur = arr[i];
            Integer count = countMap.get(cur);
            if (count == null || count == 0) {
                return false;
            }
            countMap.put(cur, --count);
        }
        return true;
    }

    
}