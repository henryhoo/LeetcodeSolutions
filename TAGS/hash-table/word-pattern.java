/*
 Given a pattern and a string str , find if str follows the same pattern.  Here
follow means a full match, such that there is a bijection between a letter in
pattern and a non-empty word in str .   Examples:   pattern = "abba" , str =
"dog cat cat dog" should return true.  pattern = "abba" , str = "dog cat cat
fish" should return false.  pattern = "aaaa" , str = "dog cat cat dog" should
return false.  pattern = "abba" , str = "dog dog dog dog" should return false.
Notes: You may assume pattern contains only lowercase letters, and str contains
lowercase letters separated by a single space.  Credits: Special thanks to
@minglotus6 for adding this problem and creating all test cases.   Subscribe to
see which companies asked this question    Show Tags   Hash Table     Show
Similar Problems   (E) Isomorphic Strings  (H) Word Pattern II
*/

//1st
public class Solution {    public boolean wordPattern(String pattern, String str) {        String[] s = str.split(" ");        HashMap<Character, String> map = new HashMap<Character, String>();        if (s.length != pattern.length())            return false;        for (int i = 0; i < s.length; i++) {            if (!map.containsKey(pattern.charAt(i))){                if (map.containsValue(s[i]))                    return false;                map.put(pattern.charAt(i), s[i]);            }            if (!map.get(pattern.charAt(i)).equals(s[i]))                return false;        }        return true;    }}