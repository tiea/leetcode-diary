import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

class Solution {

    Map<Integer, Integer> powerMap = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        int len = hi - lo + 1;
        int[] power = new int[len];
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
            power[i] = getPower(lo + i);
        }
        Arrays.sort(idx, (l, r) -> {
            if (power[l] == power[r]) {
                return l - r;
            }
            return power[l] - power[r];
        });
        return idx[k - 1] + lo;
    }

    public int getPower(int num) {
        if (powerMap.containsKey(num)) {
            return powerMap.get(num);
        }
        int nextNum = 0;
        if (num % 2 == 0) {
            nextNum = num / 2;
        } else {
            nextNum = 3 * num + 1;
        }
        if (nextNum == 1) {
            return 1;
        }
        int power = getPower(nextNum) + 1;
        powerMap.put(num, power);
        return power;
    }

}