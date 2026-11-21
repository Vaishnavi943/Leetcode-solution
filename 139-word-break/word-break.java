class Solution {
    class Node {
        Node[] next = new Node[26];
        boolean isWord = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for (String w : wordDict) {
            Node curr = root;
            for (char c : w.toCharArray()) {
                if (curr.next[c - 'a'] == null) curr.next[c - 'a'] = new Node();
                curr = curr.next[c - 'a'];
            }
            curr.isWord = true;
        }

        return solve(s, 0, root, new boolean[s.length()]);
    }

    private boolean solve(String s, int start, Node root, boolean[] bad) {
        if (start == s.length()) return true;
        if (bad[start]) return false;

        Node curr = root;
        for (int i = start; i < s.length(); i++) {
            curr = curr.next[s.charAt(i) - 'a'];
            if (curr == null) break;

            if (curr.isWord && solve(s, i + 1, root, bad)) {
                return true;
            }
        }

        bad[start] = true;
        return false;
    }
}
