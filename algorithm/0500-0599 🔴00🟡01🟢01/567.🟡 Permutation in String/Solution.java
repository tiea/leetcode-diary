import java.util.Map;
import java.util.Optional;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < len1; i++) {
            ++count1[s1.charAt(i) - 'a'];
            ++count2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        for (int i = len1; i < len2; ++i) {
            ++count2[s2.charAt(i) - 'a'];
            --count2[s2.charAt(i - len1) - 'a'];
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkInclusionHash(String s1, String s2) {
        int sLen = s1.length();
        int len = s2.length();
        if (sLen > len) {
            return false;
        }
        Map<Character, Integer> cMap = new HashMap<>(sLen);
        for (int i = 0; i < sLen; i++) {
            char c = s1.charAt(i);
            Integer count = Optional.ofNullable(cMap.get(c)).orElse(0);
            cMap.put(c, ++count);
        }
        for (int i = 0; i <= len - sLen; i++) {
            Map<Character, Integer> tmpMap = new HashMap<>(cMap);
            boolean match = true;
            for (int j = i; j < sLen + i; j++) {
                char c = s2.charAt(j);
                Integer count = tmpMap.get(c);
                if (count == null) {
                    match = false;
                    break;
                }
                if (count == 1) {
                    tmpMap.remove(c);
                } else {
                    tmpMap.put(c, --count);
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

}