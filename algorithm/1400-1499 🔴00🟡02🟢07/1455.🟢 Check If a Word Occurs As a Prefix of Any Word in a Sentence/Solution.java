class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1, ptr = 0;
        int length = sentence.length();
        int searchLength = searchWord.length();
        if (sentence.charAt(0) != ' ') {
            sentence = ' ' + sentence;
        }
        for (int i = 0; i < length; i++) {
            char c = sentence.charAt(i);
            int searchPtr = 0;
            if (c == ' ') {
                ptr++;
                i++;
                boolean success = true;
                while (i < length && searchPtr < searchLength) {
                    if (sentence.charAt(i) == ' ') {
                        success = false;
                        i--;
                        break;
                    }
                    if (searchWord.charAt(searchPtr) != sentence.charAt(i)) {
                        success = false;
                        break;
                    }
                    searchPtr++;
                    i++;
                }
                if (success) {
                    ans = ptr;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().isPrefixOfWord("b bu bur burg burger" ,"burg");
    }

}