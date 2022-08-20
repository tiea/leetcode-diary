import java.util.List;
import java.util.ArrayList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 class Solution {

    public NestedInteger deserialize(String s) {
        if (s.indexOf('[') < 0) {
            return new NestedInteger(Integer.valueOf(s));
        }
        NestedInteger ni = new NestedInteger();
        int ptr = 1;
        nextDepth(s, ptr, ni);
        return ni;
    }

    private int nextDepth(String s, int ptr, NestedInteger ni) {
        char c = s.charAt(ptr);
        char[] cList = new char[8];
        int cur = 0;
        while (c != ']') {
            ptr++;
            if (c == '[') {
                NestedInteger curNi = new NestedInteger();
                ni.add(curNi);
                ptr = nextDepth(s, ptr, curNi);
            } else if (c == ',') {
                if (cList[0] != '\u0000') {
                    ni.add(new NestedInteger(Integer.valueOf(new String(cList, 0, cur))));
                    cur = 0;
                }
                cList[0] = '\u0000';
            } else {
                cList[cur++] = c;
            }
            c = s.charAt(ptr);
        }
        if (cList[0] != '\u0000') {
            ni.add(new NestedInteger(Integer.valueOf(new String(cList, 0, cur))));
        }
        return ++ptr;
    }
    
}

class NestedInteger {

    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 0;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return new ArrayList<NestedInteger>();
    }

}