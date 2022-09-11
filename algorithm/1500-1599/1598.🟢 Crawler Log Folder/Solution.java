class Solution {

    public int minOperations(String[] logs) {
        int len = logs.length;
        int pos = 0;
        for (int i = 0; i < len; i++) {
            String cur = logs[i];
            if (cur.equals("./")) {
                continue;
            }
            if (cur.equals("../")) {
                pos = Math.max(0, pos - 1);
                continue;
            }
            pos++;
        }
        return pos;
    }

}