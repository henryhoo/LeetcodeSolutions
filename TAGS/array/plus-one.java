/*
 Given a non-negative number represented as an array of digits, plus one to the
number.  The digits are stored such that the most significant digit is at the
head of the list.   Subscribe to see which companies asked this question    Show
Tags   Array  Math     Show Similar Problems   (M) Multiply Strings  (E) Add
Binary
*/


public class Solution {    public int[] plusOne(int[] digits) {        for (int i = digits.length - 1; i >=0; i--) {            if (digits[i] < 9) {                digits[i]++;                return digits;            } else {                digits[i] = 0;            }        }        int[] newNumber = new int [digits.length+1];        newNumber[0] = 1;        return newNumber;    }}public class Solution {    public int[] plusOne(int[] digits) {        int i = digits.length - 1;        while(i >= 0) {            if (digits[i] == 9) {                digits[i] = 0;                i--;            }            else {                digits[i] += 1;                return digits;            }        }        int[] res = new int[digits.length + 1];        res[0] = 1;        return res;    }}