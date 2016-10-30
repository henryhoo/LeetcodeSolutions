/*
 Related to question Excel Sheet Column Title  Given a column title as appear in
an Excel sheet, return its corresponding column number.  For example:  A -&gt; 1
B -&gt; 2
C -&gt; 3
...
Z -&gt; 26
AA -&gt; 27
AB -&gt; 28  Credits: Special thanks to @ts for adding this problem and creating
all test cases.   Subscribe to see which companies asked this question    Show
Tags   Math     Show Similar Problems   (E) Excel Sheet Column Title
*/

public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int d = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (1 + s.charAt(i) - 'A') * Math.pow(26, d++);
        }
        return res;
    }
}
