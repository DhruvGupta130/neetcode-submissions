class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> freq = new HashMap<>();

        for (int h : hand) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            if (freq.get(hand[i]) == 0)
                continue;

            for (int j = 0; j < groupSize; j++) {
                if (freq.getOrDefault(hand[i] + j, 0) == 0)
                    return false;
                freq.put(hand[i] + j, freq.get(hand[i] + j) - 1);
            }
        }

        return true;
    }
}
