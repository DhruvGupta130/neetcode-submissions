class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, "", res);
        return res;
    }

    private void backtrack(int open, int close, int max, String curr, List<String> res) {
        if (curr.length() == 2 * max) {
            res.add(curr);
            return;
        }

        if (open < max) {
            backtrack(open + 1, close, max, curr + "(", res);
        }

        if (close < open) {
            backtrack(open, close + 1, max, curr + ")", res);
        }
    }
}
