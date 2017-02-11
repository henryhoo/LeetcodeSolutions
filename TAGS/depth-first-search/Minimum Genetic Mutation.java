public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;

        Set<String> bankSet = new HashSet<>();
        for (String b : bank) bankSet.add(b);

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c : charSet) {
                        chars[i] = c;
                        String next = new String(chars);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    chars[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
