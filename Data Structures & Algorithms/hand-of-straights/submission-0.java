class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Arrays.sort(hand);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : hand) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {
            if (freq.get(num) == 0)
                continue;

            for (int i = 0; i < groupSize; i++) {
                int curr = num + i;
                if (freq.getOrDefault(curr, 0) == 0) {
                    return false;
                }
                freq.put(curr, freq.get(curr) - 1);
            }
        }
        return true;
    }
}
