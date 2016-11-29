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
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.contains("["))
            return helper(s);
        return new NestedInteger(Integer.valueOf(s));
    }
    private NestedInteger helper (String s) {
        char[] c = s.toCharArray();
        int count = 1;
        int start = 0;
        NestedInteger node = new NestedInteger();
        for (int i = 1; i < c.length; i++) {
            if (c[i] == ',')
                continue;
            else if (c[i] == '[') {
                count++;
                if (count == 2)
                    start = i;
            } else if (c[i] == ']') {
                count--;
                if (count == 1) {
                    NestedInteger newNode = helper(s.substring(start, i));
                    node.add(newNode);
                }
                if (count == 0)
                    return node;
            } else if (count == 1){
                int j = i;
                while (j < s.length() && (c[j] != '[' && c[j]!=']' && c[j] != ','))
                    j++;
                NestedInteger newNode = new NestedInteger(Integer.valueOf(s.substring(i, j)));
                node.add(newNode);
                i = j;
            }
        }
        return node;
    }
}
