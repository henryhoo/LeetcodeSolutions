/*
 Given a string s and a dictionary of words dict , add spaces in s to construct
a sentence where each word is a valid dictionary word.  Return all such possible
sentences.  For example, given  s = "catsanddog" ,  dict = ["cat", "cats",
"and", "sand", "dog"] .  A solution is ["cats and dog", "cat sand dog"] .
Subscribe to see which companies asked this question    Show Tags   Dynamic
Programming  Backtracking
*/
public class Solution {
    List<String> res = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        DFS(s, wordDict, 0, new LinkedList<>());
        return res;
    }

    private void DFS (String s, List<String> wordDict, int index, List<String> curRes) {
        for (String w : wordDict) {
            int pos = index + w.length();
            if (pos > s.length())
                continue;
            if (s.substring(index, pos).equals(w)) {
                if (pos == s.length()) {
                    curRes.add(curRes.size() == 0 ? w : (" " + w));
                    StringBuilder sb = new StringBuilder();
                    for (String ss : curRes) {
                        sb.append(ss);
                    }
                    res.add(sb.toString());
                }
                else {
                    curRes.add(curRes.size() == 0 ? w : (" " + w));
                    DFS(s, wordDict, pos, curRes);
                }
                curRes.remove(curRes.size() - 1);
            }
        }

    }
}


public class Solution {
    // List<String> res = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>();
        for (String w : wordDict) {
            dict.add(w);
        }

        return wordBreak1(s, dict);
    }

// 我们用DFS来解决这个问题吧
    public static List<String> wordBreak1(String s, Set<String> dict) {

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if (s == null || s.length() == 0 || dict == null) {
            return null;
        }

        return dfs(s, dict, map);
    }

    // 解法1：我们用DFS来解决这个问题吧
    public static List<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<String>();
        int len = s.length();

        if (len == 0) {
            list.add("");
        } else {
            // i 表示左边字符串的长度
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);

                // 左边的子串可以为空，或是在字典内
                if (!dict.contains(sub)) {
                    continue;
                }

                // 字符串划分为2边，计算右边的word break.
                List<String> listRight = dfs(s.substring(i, len), dict, map);

                // 右边不能break的时候，我们跳过.
                if (listRight.size() == 0) {
                    continue;
                }

                // 把左字符串加到右字符串中，形成新的解.
                for (String r: listRight) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sub);
                    if (i != 0 && i != len) {
                        // 如果左边为空，或是右边为空，不需要贴空格
                        sb.append(" ");
                    }
                    sb.append(r);
                    list.add(sb.toString());
                }
            }
        }

        map.put(s, list);
        return list;
    }
}
