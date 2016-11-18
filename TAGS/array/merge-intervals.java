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
 public class Solution {     public List<Interval> merge(List<Interval> intervals) {         if (intervals.size() < 1) return new LinkedList<>();         Collections.sort(intervals, new Comparator<Interval>(){             public int compare(Interval o1, Interval o2){                 return o1.start - o2.start;             }         });         List<Interval> res = new LinkedList<>();         Interval prev = intervals.get(0);         for (Interval i : intervals) {             if (i.start > prev.end) {                 res.add(prev);                 prev = i;             } else {                 prev.start = Math.min(prev.start, i.start);                 prev.end = Math.max(prev.end, i.end);             }         }         res.add(prev);         return res;     } }