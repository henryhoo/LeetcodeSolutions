/*
 Given n non-negative integers representing an elevation map where the width of
each bar is 1, compute how much water it is able to trap after raining.  For
example, Given [0,1,0,2,1,0,1,3,2,1,2,1] , return 6 .    The above elevation map
is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain
water (blue section) are being trapped. Thanks Marcos for contributing this
image!   Subscribe to see which companies asked this question    Show Tags
Array  Stack  Two Pointers     Show Similar Problems   (M) Container With Most
Water  (M) Product of Array Except Self
*/

public class Solution {
    public int trap(int[] A) {
        int i = 0;
        int j = A.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (i <= j) {
            leftMax = Math.max(A[i], leftMax);
            rightMax = Math.max(A[j], rightMax);
            if (leftMax < rightMax) {
                sum += (leftMax - A[i++]);
            } else {
                sum += (rightMax - A[j--]);
            }
        }
        return sum;
    }
}
