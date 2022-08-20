import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int length = words.length;
        int pLength = pattern.length();
        int ptr = 0, arrPtr = 0, charNum = 1;
        int[] patternArr = new int[pLength];
        char pre = '0';
        do {
            char cur = pattern.charAt(ptr);
            if (cur == pre) {
                charNum++;
                continue;
            }
            pre = cur;
            patternArr[arrPtr++] = charNum;
            charNum = 1;
        } while (++ptr < pLength);
        List<String> result = new ArrayList<>();
        Map<Character, Character> sourceMap = null;
        Map<Character, Character> targetMap = null;
        String word = null;
        ptr = 0;
        boolean success = true;
        for (int i = 0; i < length; i++) {
            word = words[i];
            ptr = 0;
            sourceMap = new HashMap<>();
            targetMap = new HashMap<>();
            success = true;
            arrPtr = 0;
            do {
                charNum = patternArr[arrPtr++];
                char source = word.charAt(ptr);
                Character rel = sourceMap.get(source);
                char target = pattern.charAt(ptr);
                if (rel == null) {
                    if (targetMap.get(target) == null) {
                        sourceMap.put(source, target);
                        targetMap.put(target, source);
                        continue;
                    }
                    success = false;
                    break;
                }
                if (rel != target) {
                    success = false;
                    break;
                }
                if (charNum > 1) {
                    do {
                        if (source != word.charAt(ptr++)) {
                            success = false;
                            break;
                        }
                    } while(--charNum > 1);
                    arrPtr += (charNum - 1);
                    if (!success) {
                        break;
                    }
                }
            } while (++ptr < pLength);
            if (success) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"zstaqlmffddwlvvuprec","qaysbdvrrxxkdjjehgup","rjvbsghttccqgddmokpe","leipqfrssaaxfnndkguo","mlkhxaevvrrwaoogsbtu","jwtmdsubbccvsffieylp","hqbjuiyvvxxsizzawpcn","oiukdrfyynnerttwvqxs","axbyihlrrnnohsskpude","ptiaexgddjjhxkkzyvol"};
        String pattern = "mrctguqnnbbauddkzxiv";
        new Solution().findAndReplacePattern(words, pattern);
    }

}