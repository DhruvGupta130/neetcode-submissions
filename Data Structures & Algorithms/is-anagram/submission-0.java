class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c = s.toCharArray(), d = t.toCharArray();

        Arrays.sort(c);
        Arrays.sort(d);

        return Arrays.equals(c, d);
    }
}
