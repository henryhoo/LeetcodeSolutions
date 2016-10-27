/*
 Given a string containing just the characters '(' , ')' , '{' , '}' , '[' and
']' , determine if the input string is valid.  The brackets must close in the
correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
Subscribe to see which companies asked this question    Show Tags   Stack
String     Show Similar Problems   (M) Generate Parentheses  (H) Longest Valid
Parentheses  (H) Remove Invalid Parentheses
*/


public class Solution {    public boolean isValid(String s) {        Stack<Character> stack = new Stack<>();        char[] c = s.toCharArray();        for(char cc : c) {            if (cc == '(' || cc == '{' || cc == '[') {                stack.push(cc);            } else if (cc == ')' || cc == '}' || cc == ']') {                if (stack.isEmpty()) return false;                char pop = stack.pop();                switch(cc){                    case ')':                        if (pop != '(') return false;                        break;                    case '}':                        if (pop != '{') return false;                        break;                    case ']':                        if (pop != '[') return false;                        break;                }            } else {                return false;            }        }        return stack.isEmpty();    }}