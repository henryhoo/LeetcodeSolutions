public class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[52];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            if (map[s.charAt(i) - 'a'] == 1) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int t = q.remove();
            if (map[s.charAt(t) - 'a'] == 1) return t;
        }
        return -1;
    }
}
public static int firstUniqChar(String s) {

		char[] a = s.toCharArray();

		for(int i=0; i<a.length;i++){
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
		}
		return -1;
    }
