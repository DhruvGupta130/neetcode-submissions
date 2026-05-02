class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];

            if (a.length() > b.length() && a.startsWith(b))
                return "";

            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    char u = a.charAt(j), v = b.charAt(j);
                    if (!graph.get(u).contains(v)) {
                        graph.get(u).add(v);
                        indegree[v - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0)
                q.offer(c);
        }

        StringBuilder res = new StringBuilder();

        while (!q.isEmpty()) {
            char c = q.poll();

            res.append(c);

            for (char nei : graph.get(c)) {
                if (--indegree[nei - 'a'] == 0) {
                    q.offer(nei);
                }
            }
        }
        return res.length() == graph.size() ? res.toString() : "";
    }
}
