/*
 Given a collection of intervals, merge all overlapping intervals.  For example,
Given [1,3],[2,6],[8,10],[15,18] , return [1,6],[8,10],[15,18] .   Subscribe to
see which companies asked this question    Show Tags   Array  Sort     Show
Similar Problems   (H) Insert Interval  (E) Meeting Rooms  (M) Meeting Rooms II
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        List<Interval> res = new ArrayList();
        int[] starts = new int[len+1], ends = new int[len+1];
        int i = 0, j = 0, count = 0, temp = 0;
        for(Interval in : intervals){
            starts[i] = in.start;
            ends[i++] = in.end;
        }
        i = 0;
        starts[len] = Integer.MAX_VALUE;
        ends[len] = Integer.MIN_VALUE;
        sort(starts, 0, len-1);
        sort(ends, 0, len-1);
        temp = starts[0];
        while(i<len || j<len){
            if(starts[i]<=ends[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            if(count == 0){
                Interval t = new Interval(temp, ends[j-1]);
                res.add(t);
                if(i<len ){
                    temp = starts[i];
                    i++;
                    count++;
                }
            }
        }
        return res;
    }
    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


}
//2nd
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 1) return new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new LinkedList<>();
        Interval prev = intervals.get(0);
        for (Interval i : intervals) {
            if (i.start > prev.end) {
                res.add(prev);
                prev = i;
            } else {
                prev.start = Math.min(prev.start, i.start);
                prev.end = Math.max(prev.end, i.end);
            }
        }
        res.add(prev);
        return res;
    }
}
