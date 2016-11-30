public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length < 1) return 0;
        Arrays.sort(points,(a, b)->(a[0] - b[0]));
        int end = points[0][1];
        int res = 1;
        for (int i = 0 ; i < points.length; i++) {
            int[] cur = points[i];
            if (cur[0] <= end) {
                end = Math.min(cur[1], end);
            } else {
                end = cur[1];
                res++;
            }
        }
        return res;
    }
}
