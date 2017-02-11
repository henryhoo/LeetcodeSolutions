public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> x = new ArrayList<>(m);
        List<Integer> y = new ArrayList<>(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return get(x) + get(y);
    }
    private int get(List<Integer> list) {
        Collections.sort(list);
        int ret = 0;
        int i = 0, j = list.size() - 1;
        while (i < j)
            ret += list.get(j--) - list.get(i++);
        return ret;
    }
}
