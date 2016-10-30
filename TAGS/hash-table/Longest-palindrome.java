public class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                res++;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (set.isEmpty()) return res * 2;
        else return res * 2 + 1;
    }
}
