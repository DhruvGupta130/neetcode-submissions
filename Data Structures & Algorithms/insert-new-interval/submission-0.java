class Solution {
    public int[][] insert(int[][] intervals, int[] ni) {
        List<int[]> res = new ArrayList<>();

        int j = 0;
        for (int[] i : intervals) {
            if (i[1] < ni[0]) {
                res.add(i);
            } else if (i[0] > ni[1]) {
                res.add(ni);
                ni = i;
            } else {
                ni[0] = Math.min(i[0], ni[0]);
                ni[1] = Math.max(i[1], ni[1]);
            }
        }
        res.add(ni);
        return res.toArray(int[][] ::new);
    }
}
