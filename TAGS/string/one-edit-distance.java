public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int j = 0;
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() > t.length())
                    return s.substring(i+1, s.length()).equals(t.substring(i, t.length()));
                else if (s.length() < t.length())
                    return s.substring(i, s.length()).equals(t.substring(i+1, t.length()));
                else {
                    return s.substring(i+1, s.length()).equals(t.substring(i+1, t.length()));
                }
            }
        }
        return Math.abs(s.length()-t.length()) == 1;
    }
}
