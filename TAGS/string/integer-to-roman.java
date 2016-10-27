/*
 Given an integer, convert it to a roman numeral.  Input is guaranteed to be
within the range from 1 to 3999.   Subscribe to see which companies asked this
question    Show Tags   Math  String     Show Similar Problems   (E) Roman to
Integer  (H) Integer to English Words
*/
public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(strs[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
