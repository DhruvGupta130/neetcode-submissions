class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        char[] c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int length = 0;

        int maxLength = 0;

        while (left <= right && right < s.length()) {
            while (set.contains(c[right])) {
                set.remove(c[left++]);
                length--;
            } 
            set.add(c[right++]);
            length++;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
