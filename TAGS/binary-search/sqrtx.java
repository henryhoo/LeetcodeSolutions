/*
 Implement int sqrt(int x) .  Compute and return the square root of x .
Subscribe to see which companies asked this question    Show Tags   Binary
Search  Math     Show Similar Problems   (M) Pow(x, n)
*/

// bit manipulation
public class Solution {    public int mySqrt(int x) {    long ans = 0;    long bit = 1l << 16;    while(bit > 0){        ans |= bit;        if(ans * ans > x){            ans ^= bit;        }        bit >>= 1;    }    return (int)ans;    }}//binary search soultionpublic class Solution {    public int mySqrt(int x) {    if(x<=1) return x;    long left = 0, right = x;    while(left < right){        long mid = (left + right)/2;        if(mid * mid > x){            right = mid;        }        else{            left = mid + 1;        }    }    return (int)left-1;    }}