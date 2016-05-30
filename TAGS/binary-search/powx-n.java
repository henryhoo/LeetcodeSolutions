/*
 Implement pow( x , n ).   Subscribe to see which companies asked this question
Show Tags   Binary Search  Math     Show Similar Problems   (M) Sqrt(x)
*/

//Interative solution
public class Solution {public double myPow(double x, int n) {    if(n==0) return 1;    if(n==Integer.MIN_VALUE){        x = 1/(x*x);        n = Integer.MAX_VALUE;    }    if(n<0) {        n = -n;        x = 1/x;    }    double ans = 1;    while(n>0){        if(n%2==1) ans *= x;        x *= x;        n >>= 1;    }    return ans;}}//revursive Solutionpublic class Solution {public double myPow(double x, int n) {    if(n==0) return 1;    if(n<0){        if(n==Integer.MIN_VALUE){            n = Integer.MAX_VALUE;            x = 1/(x*x);        }        n = -n;        x = 1/x;    }    return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);}}