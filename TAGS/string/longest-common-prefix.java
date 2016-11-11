/*
 Write a function to find the longest common prefix string amongst an array of
strings.   Subscribe to see which companies asked this question    Show Tags
String
*/


public class Solution {    public String longestCommonPrefix(String[] strs) {        if (strs.length <1) return "";        StringBuilder sb = new StringBuilder(strs[0]);        for (int i = 1; i < strs.length; i++) {            int j = 0;            for (int k = 0; k < Math.min(strs[i].length(), sb.length()) ; k++) {                if (strs[i].charAt(k) == sb.charAt(k)) j++;                else break;            }            sb.setLength(j);        }        return sb.toString();    }}