class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] freq = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;

             if (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(freq, window)) return true;
        }

        return false;
    }
}
