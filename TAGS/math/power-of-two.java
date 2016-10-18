/*
 Given an integer, write a function to determine if it is a power of two.
Credits: Special thanks to @jianchao.li.fighter for adding this problem and
creating all test cases.   Subscribe to see which companies asked this question
Show Tags   Math  Bit Manipulation     Show Similar Problems   (E) Number of 1
Bits  (E) Power of Three  (E) Power of Four
*/

//solution 1:
public boolean isPowerOfTwo(int n) {
final double epsilon = 1.e-10;
return (Math.log(n) / Math.log(2) + epsilon) % 1 <= 2 * epsilon;
}

//solution 2:
public boolean isPowerOfTwo(int n) {
return n > 0 && 1073741824 % n == 0;
}

//solution 3:
public boolean isPowerOfTwo(int n) {
return n>0 && Integer.toBinaryString(n).matches("^10*$");
}
