import java.util.HashSet;
import java.util.Set;

class Solution {

    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        int remain = len / 2;
        int ans = 0;
        Set<Integer> types = new HashSet<>();
        for (int i = 0; i < len && remain > 0; i++) {
            if (types.add(candyType[i])) {
                remain--;
                ans++;
            }
        }
        return ans;
    }

}

