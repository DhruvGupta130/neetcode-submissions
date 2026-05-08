class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return check(s1, 0, s2, 0, s3, 0);
    }

    private boolean check(String s1, int i, String s2, int j, String s3, int k) {
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        boolean takeS1 = false;
        boolean takeS2 = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            takeS1 = check(s1, i + 1, s2, j, s3, k + 1);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            takeS2 = check(s1, i, s2, j + 1, s3, k + 1);
        }

        return takeS1 || takeS2;
    }
}
