/*
 Given two strings s and t , determine if they are isomorphic.  Two strings are
isomorphic if the characters in s can be replaced to get t .  All occurrences of
a character must be replaced with another character while preserving the order
of characters. No two characters may map to the same character but a character
may map to itself.  For example, Given "egg" , "add" , return true.  Given "foo"
, "bar" , return false.  Given "paper" , "title" , return true.  Note: You may
assume both s and t have the same length.   Subscribe to see which companies
asked this question    Show Tags   Hash Table     Show Similar Problems   (E)
Word Pattern
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int[] spos = new int[256], tpos = new int[256];
        for(int i = 0; i < len; i++){
            int ss = s.charAt(i), tt = t.charAt(i);
            if(spos[ss] != tpos[tt])return false;
            //i+1, incase duplication of pos 0
            spos[ss] = i+1;
            tpos[tt] = i+1;
        }
        return true;
    }
}
