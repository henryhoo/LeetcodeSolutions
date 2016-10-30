public class Solution {
    public String addStrings(String num1, String num2) {
        int index = Math.max(num1.length(), num2.length());
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i>=0 && j>=0) {
            int sum = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0') + carry;
            res.append(sum%10);
            carry = sum/10;
        }
        if (i>=0) {
            while(i>=0) {
                int sum = (num1.charAt(i--) - '0') + carry;
                res.append(sum%10);
                carry = sum/10;
            }
        }
        if (j>=0) {
            while(j>=0) {
                int sum = (num2.charAt(j--) - '0') + carry;
                res.append(sum%10);
                carry = sum/10;
            }
        }
        if (carry > 0) res.append(1);
        return res.reverse().toString();
    }
}
