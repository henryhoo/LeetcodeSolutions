/*
 Write a function that takes a string as input and reverse only the vowels of a
string.   Example 1: Given s = "hello", return "holle".   Example 2: Given s =
"leetcode", return "leotcede".   Subscribe to see which companies asked this
question    Show Tags   Two Pointers  String     Show Similar Problems   (E)
Reverse String
*/


public class Solution {    public String reverseVowels(String s) {        if(s == null || s.length()==0) return s;        int i = 0, j = s.length() - 1;        char[] c = s.toCharArray();        while (!isVowel(c[i]) && i < j) i++;        while (!isVowel(c[j]) && i < j) j--;        while (i < j) {            char temp = c[i];            c[i++] = c[j];            c[j--] = temp;            while (!isVowel(c[i]) && i < j) i++;            while (!isVowel(c[j]) && j > i) j--;        }        return String.valueOf(c);    }    private boolean isVowel(char c) {        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U');    }}