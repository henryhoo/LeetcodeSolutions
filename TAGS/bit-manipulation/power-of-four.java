/*
 Given an integer (signed 32 bits), write a function to check whether it is a
power of 4.  Example: Given num = 16, return true.
Given num = 5, return false.   Follow up : Could you solve it without
loops/recursion?  Credits: Special thanks to @yukuairoy for adding this problem
and creating all test cases.   Subscribe to see which companies asked this
question    Show Tags   Bit Manipulation     Show Similar Problems   (E) Power
of Two  (E) Power of Three
*/


public class Solution {
    public boolean isPowerOfFour(int num) {
      return ((num-1)&num)==0 && (num-1)%3==0;
    }
}

public class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num,4).matches("10*");
    }
}
