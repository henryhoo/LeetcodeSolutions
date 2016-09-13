/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of
rows like this: (you may want to display this pattern in a fixed font for better
legibility) P   A   H   N
A P L S I I G
Y   I   R And then read line by line: "PAHNAPLSIIGYIR"  Write the code that will
take a string and make this conversion given a number of rows: string
convert(string text, int nRows);  convert("PAYPALISHIRING", 3) should return
"PAHNAPLSIIGYIR" .   Subscribe to see which companies asked this question
Show Tags   String
*/

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = numRows;
        StringBuilder sb = new StringBuilder();
        //first row
        for (int pos = 0; pos < s.length(); ) {
            sb.append(s.charAt(pos));
            pos += 2*(n-1);
        }
        //middle row
        for (int round = 1; round < n-1; round++) {
            for (int pos = round, k = 0; pos < s.length(); k++) {
                sb.append(s.charAt(pos));
                pos += (k%2 == 0) ? 2*(n-1-round) : 2*round;
            }
        }
        //last row
        for (int pos = n-1; pos < s.length(); ) {
            sb.append(s.charAt(pos));
            pos += 2*(n-1);
        }
        return sb.toString();
    }
}
