class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> res, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr);
            return;
        }

        if (open < max) {
            generate(res, curr + "(", open + 1, close, max);
        }

        if (close < open) {
            generate(res, curr + ")", open, close + 1, max);
        }
    }
}
