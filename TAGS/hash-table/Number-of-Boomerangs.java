public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length ; i++) {
            for (int j = 0; j < points.length ; j++) {
                if (i == j) continue;
                int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for(int val : map.values()) {
            res += val * (val-1);
            }
            map.clear();
        }
        return res;
    }
}
