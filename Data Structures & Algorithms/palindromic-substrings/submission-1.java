class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            max += expand(i, i, s);
            max += expand(i, i + 1, s);
        }

        return max;
    }

    private int expand(int left, int right, String s) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
