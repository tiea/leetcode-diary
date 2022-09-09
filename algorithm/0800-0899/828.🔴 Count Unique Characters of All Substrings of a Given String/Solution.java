import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Solution {

    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            List<Integer> posList = map.get(cur);
            if (posList == null) {
                posList = new ArrayList<>();
                posList.add(-1);
                map.put(cur, posList);
            }
            posList.add(i);
        }
        int res = 0;
        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            List<Integer> posList = map.get(it.next());
            int size = posList.size();
            posList.add(len);
            for (int i = 1; i < size; i++) {
                int cur = posList.get(i);
                res += (cur - posList.get(i - 1)) * (posList.get(i + 1) - cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().uniqueLetterString("ABC");
    }

}