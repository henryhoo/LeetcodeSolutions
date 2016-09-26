/*
 A message containing letters from A-Z is being encoded to numbers using the
following mapping:  'A' -> 1
'B' -> 2
...
'Z' -> 26  Given an encoded message containing digits, determine the total
number of ways to decode it.  For example, Given encoded message "12" ,
it could be decoded as "AB" (1 2) or "L" (12).  The number of ways decoding "12"
is 2.   Subscribe to see which companies asked this question    Show Tags
Dynamic Programming  String
*/


public class Solution {    public int numDecodings(String s) {        char[] c = s.toCharArray();        int r2 = 1, r1 = 1;        for (int i = 1; i < c.length(); i++) {            if (c[i] == '0') r1 = 0;            else if (c[i-1] == '1' || (c[i-1] == '2' && c[i] <= '6')) {                int t = r1;                r1 = r1 + r2;                r2 = t;            }            else {                r2 = r1;            }        }        return r1;    }}