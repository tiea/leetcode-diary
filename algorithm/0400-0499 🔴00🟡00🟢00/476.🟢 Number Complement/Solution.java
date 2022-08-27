class Solution {

    public int findComplement(int num) {
        long sum = 1;
        while (true) {
            if (num >= sum) {
                sum <<= 1;
            } else {
                return (int) sum - num - 1;
            }
        }
    }

    public int findComplementString(int num) {
        String binary = Integer.toBinaryString(num);
        String ansStr = "";
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '0') {
                ansStr += '1';
            } else {
                ansStr += '0';
            }
        }
        return Integer.parseInt(ansStr, 2);  
    }

}