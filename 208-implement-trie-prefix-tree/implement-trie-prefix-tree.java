class Trie {
    class Node {
        Node[] next = new Node[26];
        boolean isWord = false;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    // insert a word into the Trie
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }
            curr = curr.next[idx];
        }
        curr.isWord = true;
    }

    // returns true if the exact word is in the Trie
    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.next[idx] == null) return false;
            curr = curr.next[idx];
        }
        return curr.isWord; //  end at complete word
    }

    // returns true if any word starts with prefix
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.next[idx] == null) return false;
            curr = curr.next[idx];
        }
        return true; 
    }
}
