public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] == true && dict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
