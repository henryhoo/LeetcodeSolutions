/*
 Given a string array words , find the maximum value of length(word[i]) *
length(word[j]) where the two words do not share common letters.
You may assume that each word will contain only lower case letters.
If no such two words exist, return 0.   Example 1:   Given ["abcw", "baz",
"foo", "bar", "xtfn", "abcdef"] Return 16 The two words can be "abcw", "xtfn" .
Example 2:   Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The two
words can be "ab", "cd" .   Example 3:   Given ["a", "aa", "aaa", "aaaa"] Return
0 No such pair of words.  Credits: Special thanks to @dietpepsi for adding this
problem and creating all test cases.   Subscribe to see which companies asked
this question    Show Tags   Bit Manipulation
*/

public class Solution {
    public int maxProduct(String[] words) {
        //sort words for later pruning
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String w1, String w2) {
                return w2.length() - w1.length();
            }
        });
        //masks for each character's appearance
        int[] masks = new int[words.length];
        //construct apperance
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                masks[i] |= (1 << (c - 'a'));
            }
        }
        //compute maxProduct
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                //prune branches
                if (words[i].length() * words[j].length() <= max)
                    break;
                if ((masks[i] & masks[j]) == 0) {
                    max = Mathå.max(words[i].length() * words[j].length(), max);
                    break;
                }
            }
        }
        return max;
    }
}
