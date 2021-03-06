/*
 Given an integer n , return the number of trailing zeroes in n !.  Note: Your
solution should be in logarithmic time complexity.  Credits: Special thanks to
@ts for adding this problem and creating all test cases.   Subscribe to see
which companies asked this question    Show Tags   Math     Show Similar
Problems   (H) Number of Digit One
*/
public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n>0){
            res += n/5;
            n/=5;
        }
        return res;
    }
}
