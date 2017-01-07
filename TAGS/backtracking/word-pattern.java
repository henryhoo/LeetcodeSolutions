public class Solution {
    private HashMap<Character, String> map = new HashMap<>();
    private HashSet<String> set = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        return helper(pattern, 0, str, 0);
    }

    private boolean helper(String pat, int pp, String str, int sp) {
        if (pp == pat.length() && sp == str.length())
            return true;
        if (pp == pat.length() || sp == str.length())
            return false;

        char p = pat.charAt(pp);
        if (map.containsKey(p)) {
            String match = map.get(p);
            if (!str.startsWith(match, sp))
                return false;
            return helper(pat, pp+1, str, sp + match.length());
        } else {
            for (int i = sp + 1; i <= str.length(); i++) {
                String newMatch = str.substring(sp, i);
                if (!set.contains(newMatch)) {
                   map.put(p, newMatch);
                   set.add(newMatch);
                   if (helper(pat, pp+1, str, i))
                        return true;
                   map.remove(p);
                   set.remove(newMatch);
                }
            }
        }
        return false;
    }
}
