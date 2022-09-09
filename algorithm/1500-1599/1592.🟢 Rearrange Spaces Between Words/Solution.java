class Solution {

    public String reorderSpaces(String text) {
        int spaceCount = 0, wordCount = 0;
        int len = text.length();
        char pre = ' ';
        for (int i = 0; i < len; i++) {
            char cur = text.charAt(i);
            if (cur == ' ') {
                spaceCount++;
                pre = cur;
                continue;
            }
            if (pre == ' ') {
                pre = cur;
                wordCount++;
            }
        }
        if (spaceCount == 0) {
            return text;
        }
        int avg = wordCount > 1 ? spaceCount / (wordCount - 1) : 0;
        int mod = spaceCount - avg * (wordCount - 1);
        StringBuffer sb = new StringBuffer();
        int pos = 0;
        boolean start = false;
        for (int i = 0; i < wordCount; i++) {
            if (pos >= len) {
                break;
            }
            char cur = text.charAt(pos);
            while (cur == ' ' && pos < len) {
                pos++;
                if (pos < len) {
                    cur = text.charAt(pos);
                }
            }
            while (cur != ' ' && pos < len) {
                start = true;
                sb.append(cur);
                pos++;
                if (pos < len) {
                    cur = text.charAt(pos);
                }
            }
            pos++;
            if (start && i < wordCount - 1) {
                for (int j = 0; j < avg; j++) {
                    sb.append(' ');
                }
            }
        }
        for (int j = 0; j < mod; j++) {
            sb.append(' ');
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        new Solution().reorderSpaces("c           v");
    }

}