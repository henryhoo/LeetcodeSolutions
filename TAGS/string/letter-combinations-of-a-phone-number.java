/*
 Given a digit string, return all possible letter combinations that the number
could represent.  A mapping of digit to letters (just like on the telephone
buttons) is given below.    Input: Digit string "23" Output: ["ad", "ae", "af",
"bd", "be", "bf", "cd", "ce", "cf"].   Note: Although the above answer is in
lexicographical order, your answer could be in any order you want.   Subscribe
to see which companies asked this question    Show Tags   Backtracking  String
Show Similar Problems   (M) Generate Parentheses  (M) Combination Sum
*/


public class Solution {    String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};    public List<String> letterCombinations(String digits) {        LinkedList<String> res = new LinkedList<>();        if(digits.length() ==0 ) return res;        res.add("");        for(int i = 0; i < digits.length(); i++) {            int x = Character.getNumericValue(digits.charAt(i));            while(res.peek().length()==i) {                String t = res.remove();                for(char s : map[x].toCharArray()) {                    res.add(t+s);                }            }        }        return res;    }}