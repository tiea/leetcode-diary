import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {

    public int longestPalindrome(String[] words) {
        int ans = 0;
        int length = words.length;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String word = words[i];
            Integer count = countMap.get(word);
            if (count == null) {
                count = 0;
            }
            countMap.put(word, ++count);
        }
        boolean foundCenter = false;
        Iterator<String> iterator = countMap.keySet().iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            Integer count = countMap.get(word);
            if (count == null || count == 0) {
                continue;
            }
            boolean same = (word.charAt(0) == word.charAt(1));
            if (same) {
                if (count % 2 == 1) {
                    if (!foundCenter) {
                        foundCenter = true;
                        ans += (count * 2);
                    } else {
                        ans += ((count - 1) * 2);
                    }
                } else if (count % 2 == 0) {
                    ans += (count * 2);
                }
                iterator.remove();
                continue;
            }
            String reWord = "" + word.charAt(1) + word.charAt(0);
            Integer reCount = countMap.get(reWord);
            if (reCount != null && reCount > 0) {
                ans += (((count > reCount) ? reCount : count) * 4);
            }
            iterator.remove();
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"});
    }
}