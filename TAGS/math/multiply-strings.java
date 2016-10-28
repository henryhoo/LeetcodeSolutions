/*
 Given two numbers represented as strings, return multiplication of the numbers
as a string.  Note:   The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.  You should NOT use
internal library such as BigInteger .    Subscribe to see which companies asked
this question    Show Tags   Math  String     Show Similar Problems   (M) Add
Two Numbers  (E) Plus One  (E) Add Binary
*/


public class Solution {    public String multiply(String num1, String num2) {        int[] res = new int[num1.length() + num2.length()];        for (int i = num2.length() - 1; i>=0; i--) {            for (int j = num1.length()-1; j>=0; j--) {                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');                int sum = mul + res[i+j+1];                res[i+j+1] = sum%10;                res[i+j] += sum/10;            }        }        StringBuilder sb = new StringBuilder();        int i = 0;        while (res[i] == 0 && i<res.length-1) i++;        for (i = i; i<res.length; i++) {            sb.append(res[i]);        }        return sb.toString();    }}