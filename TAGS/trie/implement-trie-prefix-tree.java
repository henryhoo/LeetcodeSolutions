/*
 Implement a trie with insert , search , and startsWith methods.   Note: You may
assume that all inputs are consist of lowercase letters a-z .   Subscribe to see
which companies asked this question    Show Tags   Design  Trie     Show Similar
Problems   (M) Add and Search Word - Data structure design
*/


class TrieNode {    // Initialize your data structure here.    public boolean isWord;    public TrieNode[] next = new TrieNode[26];    public char val;    public TrieNode() {    }    public TrieNode(char c) {        TrieNode node = new TrieNode();        node.val = c;    }}public class Trie {    private TrieNode root;    public Trie() {        root = new TrieNode();        root.val = ' ';    }    // Inserts a word into the trie.    public void insert(String word) {        TrieNode walk = root;        for (int i = 0; i < word.length(); i++) {            char c = word.charAt(i);            if (walk.next[c - 'a'] == null)                walk.next[c - 'a'] = new TrieNode(c);            walk = walk.next[c - 'a'];        }        walk.isWord = true;    }    // Returns if the word is in the trie.    public boolean search(String word) {        TrieNode walk = root;        for (int i = 0; i < word.length(); i++) {            char c = word.charAt(i);            if (walk.next[c - 'a'] == null)                return false;            walk = walk.next[c - 'a'];        }        return walk.isWord;    }    // Returns if there is any word in the trie    // that starts with the given prefix.    public boolean startsWith(String prefix) {        TrieNode walk = root;        for (int i = 0; i < prefix.length(); i++) {            char c = prefix.charAt(i);            if (walk.next[c - 'a'] == null)                return false;            walk = walk.next[c - 'a'];        }        return true;    }}// Your Trie object will be instantiated and called as such:// Trie trie = new Trie();// trie.insert("somestring");// trie.search("key");

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
