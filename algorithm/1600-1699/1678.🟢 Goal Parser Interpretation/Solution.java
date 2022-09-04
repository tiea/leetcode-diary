class Solution {

    public String interpret(String command) {
        StringBuffer result = new StringBuffer();
        int length = command.length(), ptr = 0;
        char c;
        while (ptr < length) {
            c = command.charAt(ptr++);
            if (c == 'G') {
                result.append("G");
            } else if (c == '(') {
                if (command.charAt(ptr) == ')') {
                    result.append("o");
                    ptr++;
                } else {
                    result.append("al");
                    ptr += 2;
                }
            }
        }
        return result.toString();
    }
    
}