//https://leetcode.com/problems/implement-trie-prefix-tree/
//实现前缀树

class TrieNode {
    // Initialize your data structure here.
    boolean hasValue;
    TrieNode[] child;
    
    public TrieNode() {
        hasValue = false;
        child = new TrieNode[26];
    }
    
    public TrieNode(boolean hasValue) {
        this.hasValue = hasValue;
        child = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++) {
            if(temp.child[word.charAt(i)-'a'] == null) {
                temp.child[word.charAt(i)-'a'] = new TrieNode();
            }
            if(i == word.length()-1)
            	temp.child[word.charAt(i)-'a'].hasValue = true;
            else
                temp = temp.child[word.charAt(i)-'a'];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++) {
            if(temp.child[word.charAt(i)-'a'] == null)
                return false;
            temp = temp.child[word.charAt(i)-'a'];
        }
        return temp.hasValue;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0; i<prefix.length(); i++) {
            if(temp.child[prefix.charAt(i)-'a'] == null)
                return false;
            temp = temp.child[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
