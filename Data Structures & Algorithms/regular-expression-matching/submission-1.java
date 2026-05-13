class Solution {
    public boolean isMatch(String s, String p) {
        char[] c = s.toCharArray();
        char[] d = p.toCharArray();

        Boolean[][] dp = new Boolean[c.length + 1][d.length + 1];
        return check(c, 0, d, 0, dp);
    }

    private boolean check(char[] c, int i, char[] d, int j, Boolean[][] dp) {
        if (j == d.length)
            return i == c.length;

        boolean match = i < c.length && (c[i] == d[j] || d[j] == '.');

        if (j + 1 < d.length && d[j + 1] == '*') {
            return check(c, i, d, j + 2, dp) || (match && check(c, i + 1, d, j, dp));
        } else {
            return match && check(c, i + 1, d, j + 1, dp);
        }
    }
}
