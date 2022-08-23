import java.util.*;

class Solution {

    public String kthDistinct(String[] arr, int k) {
        int length = arr.length;
        List<String> ansList = new ArrayList<>();
        Map<String, Integer> countMap = new LinkedHashMap<>(length);
        String cur = "";
        Integer count = null;
        for (int i = 0; i < length; i++) {
            cur = arr[i];
            count = countMap.get(cur);
            if (count == null) {
                count = 0;
            }
            countMap.put(cur, ++count);
        }
        
        countMap.forEach((key, value) -> {
            if (value == 1) {
                ansList.add(key);
            }
        });

        if (ansList.size() >= k) {
            return ansList.get(k - 1);
        }
        return "";
    }

}