/*
  Follow up for H-Index : What if the citations array is sorted in ascending
order? Could you optimize your algorithm?   Expected runtime complexity is in O
(log n ) and the input is sorted.    Subscribe to see which companies asked this
question    Show Tags   Binary Search     Show Similar Problems   (M) H-Index
*/
public class Solution {
    public int hIndex(int[] citations) {
    int len = citations.length;
    int lo = 0, hi = len - 1;
    while (lo <= hi) {
        int med = (hi + lo) / 2;
        if (citations[med] == len - med) {
            return len - med;
        } else if (citations[med] < len - med) {
            //(citations[med] < len-med), med may qualified as a hIndex,
            // we have to continue to search for a higher one.
            lo = med + 1;
        } else {
            //(citations[med] > len-med), med not qualified as a hIndex,
            // we have to continue to search for a smaller one.
            hi = med - 1;
        }
    }
    return len - lo;
    }
}
