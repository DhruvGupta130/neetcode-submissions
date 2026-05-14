class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (char c : s.toCharArray()) {
            map.put(c, i++);
        }

        System.out.println(map);

        List<Integer> res = new ArrayList<>();

        int end = 0;
        int size = 0;
        for (i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            size++;
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
