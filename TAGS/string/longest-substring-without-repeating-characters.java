/*
 Given a string, find the length of the longest substring without repeating
characters.  Examples:  Given "abcabcbb" , the answer is "abc" , which the
length is 3.  Given "bbbbb" , the answer is "b" , with the length of 1.  Given
"pwwkew" , the answer is "wke" , with the length of 3. Note that the answer must
be a substring , "pwke" is a subsequence and not a substring.   Subscribe to see
which companies asked this question    Show Tags   Hash Table  Two Pointers
String     Show Similar Problems   (H) Longest Substring with At Most Two
Distinct Characters
*/


public class Solution {    public int lengthOfLongestSubstring(String s) {        int max = 0;        HashSet<Character> set = new HashSet<Character>();        for (int i = 0, j = 0; i < s.length(); ++i) {            if(set.contains(s.charAt(i))) {                while(s.charAt(j) != s.charAt(i)) {                    set.remove(s.charAt(j));                    j++;                }                j++;            } else {                set.add(s.charAt(i));                max = Math.max(max,i-j+1);            }        }        return max;    }}//beeter solution from leetcodepublic int lengthOfLongestSubstring(String s) {     if (s.length()==0) return 0;     HashMap<Character, Integer> map = new HashMap<Character, Integer>();     int max=0;     for (int i=0, j=0; i<s.length(); ++i){         if (map.containsKey(s.charAt(i))){             j = Math.max(j,map.get(s.charAt(i))+1);         }         map.put(s.charAt(i),i);         max = Math.max(max,i-j+1);     }     return max; }