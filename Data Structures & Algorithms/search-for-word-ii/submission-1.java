class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word;
}

class Solution {
    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.word = word;
        }

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char c = board[i][j];

        if (c == '#' || !node.children.containsKey(c))
            return;

        node = node.children.get(c);

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            dfs(board, i + dx[d], j + dy[d], node);
        }

        board[i][j] = c;
    }
}