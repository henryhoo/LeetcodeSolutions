/*
 The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...    1 is read off as "one 1" or 11 .  11 is read off
as "two 1s" or 21 .  21 is read off as "one 2 , then one 1" or 1211 .   Given an
integer n , generate the n th sequence.  Note: The sequence of integers will be
represented as a string.    Subscribe to see which companies asked this question
Show Tags   String     Show Similar Problems   (M) Encode and Decode Strings
*/


public class Solution {    public String countAndSay(int n) {        StringBuilder sb = new StringBuilder("1");        for (int i = 2; i <= n; i++) {            StringBuilder t = new StringBuilder();            char c = sb.charAt(0);            int count = 1;            for (int j = 1; j < sb.length(); j++) {                if(sb.charAt(j) == c) count++;                else {                    t.append(count);                    t.append(c);                    c = sb.charAt(j);                    count = 1;                }            }            t.append(count);            t.append(c);            sb = new StringBuilder(t);        }        return sb.toString();    }}