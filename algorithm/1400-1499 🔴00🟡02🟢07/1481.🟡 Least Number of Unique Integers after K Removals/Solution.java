import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            Integer count = map.get(item);
            if (count == null) {
                count = 0;
            }
            map.put(item, ++count);
        }
        int len = map.size();
        int[] countArr = new int[len];
        Iterator<Integer> iterator = map.keySet().iterator();
        int i = 0;
        while(iterator.hasNext()) {
            countArr[i++] = map.get(iterator.next());
        }
        Arrays.sort(countArr);
        i = 0;
        while(i < len) {
            Integer count = countArr[i++];
            if (count < k) {
                k = k - count;
                continue;
            }
            if (count == k) {
                break;
            }
            if (count > k) {
                 i--;
                break;
            }
        }
        return len - i;
    }

}
