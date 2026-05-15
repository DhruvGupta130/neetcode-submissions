class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (char c : ch) map.put(c, i++);

        List<Integer> res = new ArrayList<>();

        int max = 0, count = 0;
        i = 0;
        for (char c : ch) {
            max = Math.max(max, map.get(c));
            count++;

            if (i++ == max) {
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
}
