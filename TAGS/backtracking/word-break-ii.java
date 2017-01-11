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
