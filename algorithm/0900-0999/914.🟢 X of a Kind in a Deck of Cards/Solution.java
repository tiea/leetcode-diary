import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        int len  = deck.length;
        if (len <= 1) {
            return false;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = deck[i];
            int count = countMap.getOrDefault(num, 0);
            countMap.put(num, ++count);
        }
        Iterator<Integer> iterator = countMap.keySet().iterator();
        int gcd = countMap.get(iterator.next());
        while(iterator.hasNext()) {
            int num = iterator.next();
            gcd = gcd(countMap.get(num), gcd);
            if (gcd <= 1) {
                return false;
            }
        }
        return true;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a: gcd(b, a % b);
    }

}