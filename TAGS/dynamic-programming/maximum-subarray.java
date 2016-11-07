/*
 Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.  For example, given the array
[&#8722;2,1,&#8722;3,4,&#8722;1,2,1,&#8722;5,4] , the contiguous subarray
[4,&#8722;1,2,1] has the largest sum = 6 .  click to show more practice.  More
practice:  If you have figured out the O( n ) solution, try coding another
solution using the divide and conquer approach, which is more subtle.
Subscribe to see which companies asked this question    Show Tags   Array
Dynamic Programming  Divide and Conquer     Show Similar Problems   (E) Best
Time to Buy and Sell Stock  (M) Maximum Product Subarray
*/

//first time wrong solution, consider contiguous subarray to be increasing subarray
public class Solution {
    public int maxProduct(int[] nums) {
        int i = 0;
        int res = Integer.MIN_VALUE;
        while (i < nums.length) {
            int j = i;
            int product = nums[i];
            int neg = product >= 0 ? 0 : 1;
            while (j < nums.length - 1 && nums[j+1] == nums[j] + 1 ) { // if is increasing
                if (nums[j+1] == 0) j++;
                else {
                    product *= nums[j+1];
                    j++;
                }
                if (nums[j] < 0) neg++;
            }
            if (nums[j] >= 0) {
                if (Math.abs(product) > res) res = Math.abs(product);
            }
            else if (neg %2 == 0 || neg == 1) {
                if (product > res) res = product;
            } else  {
                if (product/nums[j] > res) res = product/nums[j];
            }
            i = j+1;
        }
        return res;
    }
}

//
public class Solution {
    public int maxProduct(int[] nums) {
        int i = 0;
        int[] res = new int [nums.length];
        int p = 1;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                p = 1;
                res[i] = 0;
            }
            else {
            p *= nums[i];
            res[i] = p;
            }
        }
        int max = Integer.MIN_VALUE;
        int minneg = -1;
        int maxneg = Integer.MIN_VALUE;
        int negc = 0;
        for (i = 0; i < res.length; i++) {
            if (res[i] > max) max = res[i];
            if (res[i] < 0) {
                negc++;
                minneg = res[i] < minneg ? res[i] : minneg;
                maxneg = res[i] > maxneg ? res[i] : maxneg;
                if (negc == 1){
                    if (max < maxneg) max = maxneg;
                }
                if (negc > 1) {
                    if (minneg/maxneg > max) max = minneg/maxneg;
                }
            }
            if (res[i] == 0) {
                minneg = -1;
                maxneg = Integer.MIN_VALUE;
                negc = 0;
            }
        }
        return max;
    }
}

//

public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
