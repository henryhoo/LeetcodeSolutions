/*
 Given an integer array nums , find the sum of the elements between indices i
and j ( i &le; j ), inclusive. The update(i, val) function modifies nums by
updating the element at index i to val . Example:  Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8   Note:   The array is only modifiable by the update
function.  You may assume the number of calls to update and sumRange function is
distributed evenly.     Subscribe to see which companies asked this question
Show Tags   Segment Tree  Binary Indexed Tree     Show Similar Problems   (E)
Range Sum Query - Immutable  (H) Range Sum Query 2D - Mutable
*/
public class NumArray {
      /**
     * Binary Indexed Trees (BIT or Fenwick tree):
     * https://www.topcoder.com/community/data-science/data-science-
     * tutorials/binary-indexed-trees/
     *
     * Example: given an array a[0]...a[7], we use a array BIT[9] to
     * represent a tree, where index [2] is the parent of [1] and [3], [6]
     * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
     * [8] is the parent of [4]. I.e.,
     *
     * BIT[] as a binary tree:
     *            ______________*
     *            ______*
     *            __*     __*
     *            *   *   *   *
     * indices: 0 1 2 3 4 5 6 7 8
     *
     * BIT[i] = ([i] is a left child) ? the partial sum from its left most
     * descendant to itself : the partial sum from its parent (exclusive) to
     * itself. (check the range of "__").
     *
     * Eg. BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
     * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
     * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
     * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
     *
     * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
     * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
     * last 1-bit from [i].
     *
     * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
     * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
     * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
     *
     * To obtain the original value of a[7] (corresponding to index [8] of
     * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
     * starting from [idx-1], for current [i], the next subtrahend [j] is
     * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
     * way but using extra space is to store the original array.)
     */
    private int[] num;
    private int[] BTsum;
    private int len;
    public NumArray(int[] nums) {
        len = nums.length;
        BTsum = new int[len+1];
        num = new int[len];
        for(int i = 0; i<len; i++){
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - num[i];
        num[i++] = val;
        while(i <= len){
            BTsum[i] += diff;
            i += (-i&i);
        }
    }
    private int getsum(int i){
        int sum = 0;
        i++;
        while(i > 0){
            sum += BTsum[i];
            i -= (-i&i);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getsum(j) - getsum(i-1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
