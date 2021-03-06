/*
 Given two binary strings, return their sum (also a binary string).  For
example, a = "11" b = "1" Return "100" .   Subscribe to see which companies
asked this question    Show Tags   Math  String     Show Similar Problems   (M)
Add Two Numbers  (M) Multiply Strings  (E) Plus One
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i>=0 && j>=0) {
            int t = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
            if (t >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(t%2);
        }
        if (i>=0) {
            while (i >=0) {
            int t = (a.charAt(i--) - '0') + carry;
            if (t >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(t%2);
            }
        }
        if (j>=0) {
            while (j >=0) {
            int t = (b.charAt(j--) - '0') + carry;
            if (t >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(t%2);
            }
        }
        return carry > 0 ? sb.append('1').reverse().toString() : sb.reverse().toString();
    }
}
