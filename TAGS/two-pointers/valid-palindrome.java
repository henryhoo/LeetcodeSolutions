/*
 Given a string, determine if it is a palindrome, considering only alphanumeric
characters and ignoring cases.  For example,  "A man, a plan, a canal: Panama"
is a palindrome.  "race a car" is not a palindrome.   Note: Have you consider
that the string might be empty? This is a good question to ask during an
interview.  For the purpose of this problem, we define empty string as valid
palindrome.   Subscribe to see which companies asked this question    Show Tags
Two Pointers  String     Show Similar Problems   (E) Palindrome Linked List
*/

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char head, tail;
        while (i < j) {
            head = s.charAt(i);
            tail = s.charAt(j);
            if (!Character.isLetterOrDigit(head))
                i++;
            else if (!Character.isLetterOrDigit(tail))
                j--;
            else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail))
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }
}
