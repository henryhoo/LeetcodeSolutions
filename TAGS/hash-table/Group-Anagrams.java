public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        for (String s : strs) {
            char[] c= s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key))
                map.put(key, new LinkedList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
