/*
 Given a string S , find the longest palindromic substring in S . You may assume
that the maximum length of S is 1000, and there exists one unique longest
palindromic substring.   Subscribe to see which companies asked this question
Show Tags   String     Show Similar Problems   (H) Shortest Palindrome  (E)
Palindrome Permutation  (H) Palindrome Pairs
*/

//Expand around center time: o(n^2), space: o(1) or o(n)
public class Solution {
    public String longestPalindrome(String s) {

        //Construct string for odd and even expend
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i)+"#");
        }
        String ss = sb.append(s.charAt(s.length()-1)).toString();
        //expend each midpoint
        int left = 0, right = 0;
        for (int i = 0; i < ss.length(); i++) {
            int l = i, r = i;
            while (l - 1 >= 0 && r + 1 < ss.length() && ss.charAt(r+1) == ss.charAt(l-1)) {
                l--;
                r++;
            }
            if (r - l + 1 > right - left + 1 || (r - l + 1 == right - left + 1) && (ss.charAt(l) != '#')) {
                left = l;
                right = r;
            }
        }
        //transform ss's index into s's index
        left = left % 2 == 0 ? left / 2 : left / 2 + 1;
        return s.substring(left, 1 + right / 2);

    }
}
//Leetcode turtorial
public String longestPalindrome(String s) {
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

//Another leetcode Solutionpublic class Solution {
    public String longestPalindrome(String s) {
    	int max = 0;
    	int a = 0, b = 0;
    	for (int i = 0; i < s.length(); i++) {

    	    int beg = i, end = i;
    	    while(end + 1 < s.length() && s.charAt(beg) == s.charAt(end + 1)) {
    	        end++;
    	    }

    	    while(beg - 1 >= 0 && end + 1 < s.length() && s.charAt(beg - 1) == s.charAt(end + 1)) {
    	        beg--;
    	        end++;
    	    }

    	    if(end - beg + 1 > max) {
    	        max = end - beg + 1;
    	        a = beg;
    	        b = end;
    	    }

    	}

    	return s.substring(a, b + 1);
    }
}

//Manaer's alogrithm time: o(n) space:o(n)
// Transform S into T.
// For example, S = "abba", T = "^#a#b#b#a#$".
// ^ and $ signs are sentinels appended to each end to avoid bounds checking
string preProcess(string s) {
  int n = s.length();
  if (n == 0) return "^$";
  string ret = "^";
  for (int i = 0; i < n; i++)
    ret += "#" + s.substr(i, 1);

  ret += "#$";
  return ret;
}

string longestPalindrome(string s) {
  string T = preProcess(s);
  int n = T.length();
  int *P = new int[n];
  int C = 0, R = 0;
  for (int i = 1; i < n-1; i++) {
    int i_mirror = 2*C-i; // equals to i' = C - (i-C)

    P[i] = (R > i) ? min(R-i, P[i_mirror]) : 0;

    // Attempt to expand palindrome centered at i
    while (T[i + 1 + P[i]] == T[i - 1 - P[i]])
      P[i]++;

    // If palindrome centered at i expand past R,
    // adjust center based on expanded palindrome.
    if (i + P[i] > R) {
      C = i;
      R = i + P[i];
    }
  }

  // Find the maximum element in P.
  int maxLen = 0;
  int centerIndex = 0;
  for (int i = 1; i < n-1; i++) {
    if (P[i] > maxLen) {
      maxLen = P[i];
      centerIndex = i;
    }
  }
  delete[] P;

  return s.substr((centerIndex - 1 - maxLen)/2, maxLen);
}
