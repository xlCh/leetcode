//添加、搜索单词的数据结构 搜索时可以使用'.'代替任意字符
//采用前缀树

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

public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode root) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == '.') {
                for(int j=0; j<26; j++) {
                    if(temp.child[j] != null) {
                        if(i==word.length()-1 && temp.child[j].hasValue)
                            return true;
                        boolean hasResult = search(word.substring(i+1), temp.child[j]);
                        if(hasResult)
                            return true;
                    }
                }
                return false;
            }
            else {
                if(temp.child[word.charAt(i)-'a'] == null)
                    return false;
                temp = temp.child[word.charAt(i)-'a'];
            }
        }
        return temp.hasValue;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
