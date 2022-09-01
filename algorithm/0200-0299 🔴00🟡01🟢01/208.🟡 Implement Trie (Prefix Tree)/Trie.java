class Trie {
    boolean end = false;
    Trie[] children = new Trie[26];

    public Trie() {

    }
    
    public void insert(String word) {
        char[] c = word.toCharArray();
        int len = c.length;
        Trie trie = this;
        for (int i = 0; i < len; i++) {
            int pos = c[i]  - 'a';
            Trie tmp = trie.children[pos];
            if (tmp == null) {
                tmp = new Trie();
                trie.children[pos] = tmp;
            }
            trie = tmp;
        }
        trie.end = true;
    }
    
    public boolean search(String word) {
        char[] c = word.toCharArray();
        int len = c.length;
        Trie trie = this;
        for (int i = 0; i < len; i++) {
            trie = trie.children[c[i]  - 'a'];
            if (trie == null) {
                return false;
            }
        }
        return trie.end;
    }
    
    public boolean startsWith(String prefix) {
        char[] c = prefix.toCharArray();
        int len = c.length;
        Trie[] children = this.children;
        for (int i = 0; i < len; i++) {
            Trie trie = children[c[i]  - 'a'];
            if (trie == null) {
                return false;
            }
            children = trie.children;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */