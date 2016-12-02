public class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1;
            while (lev + 1 < stack.size())
                stack.pop();
            int len = stack.peek() + s.length() - lev + 1;
            stack.push(len);
            if(s.contains(".")) max = Math.max(max, len-1);
        }
        return max;
    }
}
