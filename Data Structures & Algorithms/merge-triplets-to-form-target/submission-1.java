class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false;
        boolean second = false;
        boolean third = false;

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;

            first = first || target[0] == t[0];
            second = second || target[1] == t[1];
            third = third || target[2] == t[2];
        }

        return first && second && third;
    }
}
