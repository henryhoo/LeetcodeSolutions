public class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (int i = 0; i < t.length() - 1; i++) {
            res ^= t.charAt(i);
            res ^= s.charAt(i);
        }
        return (char)(res ^ t.charAt(t.length() - 1));
    }
}
