/*
 Given two strings s and t , write a function to determine if t is an anagram of
s .  For example,  s = "anagram", t = "nagaram", return true.  s = "rat", t =
"car", return false.  Note: You may assume the string contains only lowercase
alphabets.  Follow up: What if the inputs contain unicode characters? How would
you adapt your solution to such case?   Subscribe to see which companies asked
this question    Show Tags   Hash Table  Sort     Show Similar Problems   (M)
Group Anagrams  (E) Palindrome Permutation
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] feq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            feq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            feq[s.charAt(i) - 'a']--;
        }
        for (int i : feq) {
            if (i != 0) return false;
        }
        return true;
    }
}
