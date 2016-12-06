/*
 Given n non-negative integers a 1 , a 2 , ..., a n , where each represents a
point at coordinate ( i , a i ). n vertical lines are drawn such that the two
endpoints of line i is at ( i , a i ) and ( i , 0). Find two lines, which
together with x-axis forms a container, such that the container contains the
most water.  Note: You may not slant the container.   Subscribe to see which
companies asked this question    Show Tags   Array  Two Pointers     Show
Similar Problems   (H) Trapping Rain Water
*/


public class Solution {    public int maxArea(int[] height) {        int res = 0;        int l = 0, r = height.length - 1;        while (l < r) {            int area = (r - l) * Math.min(height[l], height[r]);            res = Math.max(area, res);            if (height[l] < height[r]) {                int old = height[l++];                while (height[l] < old && l <= r)                    l++;            }            else if (height[l] > height[r]) {                int old = height[r--];                while (height[r] < old && l <= r)                    r--;            } else {                int old1 = height[r--];                int old2 = height[l++];                while (height[r] < old1 && l <= r)                    r--;                while (height[l] < old2 && l <= r)                    l++;            }        }        return res;    }}