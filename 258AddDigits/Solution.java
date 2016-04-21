
/*
list the digit root of each number, there is a 1~9 circle. and 0 for 0.
*/
public class Solution {
    public int addDigits(int num) {
        if(num==0) return 0;
        return num%9==0?9:num%9;
    }
}
