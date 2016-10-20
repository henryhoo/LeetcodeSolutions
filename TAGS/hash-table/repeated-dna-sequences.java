/*
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
repeated sequences within the DNA.  Write a function to find all the 10-letter-
long sequences (substrings) that occur more than once in a DNA molecule.  For
example,  Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
Return:
["AAAAACCCCC", "CCCCCAAAAA"].   Subscribe to see which companies asked this
question    Show Tags   Hash Table  Bit Manipulation
*/


public class Solution {    public List<String> findRepeatedDnaSequences(String s) {        HashSet set = new HashSet();        HashSet resset = new HashSet();        for (int i = 0; i <= s.length() - 10; i++) {            if (set.contains(s.substring(i, i+10))) {                resset.add(s.substring(i, i+10));            } else {                set.add(s.substring(i, i+10));            }        }        return new ArrayList<>(resset);    }}