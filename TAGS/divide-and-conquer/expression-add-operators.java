/*
 Given a string that contains only digits 0-9 and a target value, return all
possibilities to add binary operators (not unary) + , - , or * between the
digits so they evaluate to the target value.  Examples:  "123", 6 -> ["1+2+3",
"1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []  Credits: Special thanks to @davidtan1890 for adding
this problem and creating all test cases.   Subscribe to see which companies
asked this question    Show Tags   Divide and Conquer     Show Similar Problems
(M) Evaluate Reverse Polish Notation  (H) Basic Calculator  (M) Basic Calculator
II  (M) Different Ways to Add Parentheses
*/

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= num.length(); i++) {
            if (i > 1 && num.charAt(0) == '0')
                break;
            long t = Long.parseLong(num.substring(0, i));
            helper(res, ""+ t , num, i, target, t, t);
        }
        return res;
    }
    private void helper(List<String> res, String path, String num, int pos, int target, long cur, long prev) {
        if (pos == num.length()) {
            if (target == cur) {
              res.add(path);
            }
            return;
        }
        for (int i = pos + 1; i <= num.length(); i++) {
            if (i > pos + 1 && num.charAt(pos) == '0')
                break;
            long t = Long.parseLong(num.substring(pos, i));
            helper(res, path + '+' + t, num, i, target, cur + t, t);
            helper(res, path + '-' + t, num, i, target, cur - t, -t);
            helper(res, path + '*' + t, num, i, target, cur - prev + prev * t, prev * t);
        }
    }
}
