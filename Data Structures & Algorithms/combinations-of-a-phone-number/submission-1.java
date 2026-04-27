class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isBlank())
            return List.of();
        List<String> res = new ArrayList<>();
        List<String> map =
            List.of("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        backtrack(digits, 0, new StringBuilder(), map, res);
        return res;
    }

    private void backtrack(
        String digits, int index, StringBuilder sb, List<String> map, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index) - '0');
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
