/*
 Given an integer array of size n , find all elements that appear more than
&lfloor; n/3 &rfloor; times. The algorithm should run in linear time and in O(1)
space.   How many majority elements could it possibly have?  Do you have a
better hint? Suggest it !    Subscribe to see which companies asked this
question    Show Tags   Array     Show Similar Problems   (E) Majority Element
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length==0) return result;
        int can1 = 0, can2 = 0, c1=0, c2=0;
        //use Boyer-Moore Majority Vote to find out candidates
        for(int n : nums){
            if(n==can1) c1++;
            else if(n==can2) c2++;
            else if(c1==0){
                can1 = n;
                c1++;
            }
            else if(c2==0){
                can2 = n;
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        //count each candidate's frequency
        for(int n : nums){
            if(n==can1)c1++;
            else if(n==can2) c2++;
        }
        //if greater than 1/3, add to result
        if(c1>nums.length/3) result.add(can1);
        if(c2>nums.length/3) result.add(can2);
        return result;
    }
}
